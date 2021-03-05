package org.gauge.xray;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.gauge.Messages.Message;
import com.thoughtworks.gauge.Messages.SuiteExecutionResult;
import okhttp3.*;
import org.gauge.xray.report.Report;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class Reporter {

    private static final String LOCALHOST = "127.0.0.1";

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient client;

    enum authentication {
        cookie,
        basic
    }

    static {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
    }


    public static void main(String[] args) {
        String portEnv = System.getenv("plugin_connection_port");
        int port = Integer.parseInt(portEnv);
        Socket socket;
        while (true) {
            try {
                socket = new Socket(LOCALHOST, port);
                break;
            } catch (Exception ignored) {
                // ignore
            }
        }

        try {
            while (!socket.isClosed() && socket.isConnected()) {
                Message message = Message.parseDelimitedFrom(socket.getInputStream());
                if (message.getMessageType() == Message.MessageType.SuiteExecutionResult) {
                    SuiteExecutionResult result = message.getSuiteExecutionResult();
                    
                    String jiraTestExecutionId = getProperty("jira_test_execution_id");
                    String jiraTestExecutionSummary = getProperty("jira_test_execution_summary");
                    
                    List<Report> reports = ReportGenerator.generate(result, jiraTestExecutionId, jiraTestExecutionSummary);
                    Gson gson = new GsonBuilder()
                            .disableHtmlEscaping()
                            .setPrettyPrinting()
                            .create();
                    String jiraBaseUrl = getProperty("jira_url");
                    String jiraUsername = getProperty("jira_username");
                    String jiraPassword = getProperty("jira_password");
                    String authentication = System.getenv().getOrDefault("jira_authentication", "cookie");
                    Credentials credentials = new Credentials(jiraUsername, jiraPassword);

                    if (Reporter.authentication.cookie.name().equalsIgnoreCase(authentication)) {
                        authenticate(jiraBaseUrl, gson.toJson(credentials));
                    }
                    System.out.println(String.format("Uploading %d test execution(s) to Jira Xray...", reports.size()));
                    for (Report report : reports) {
                        upload(jiraBaseUrl, gson.toJson(report), authentication, credentials);
                    }
                    System.exit(0);
                    return;
                }
                if (message.getMessageType() == Message.MessageType.KillProcessRequest) {
                    if (!socket.isClosed()) {
                        socket.close();
                    }
                    System.exit(0);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getProperty(String name) {
        String value = System.getenv(name);
        if (value == null) {
            throw new RuntimeException(String.format("Missing required environment property %s", name));
        }
        return value;
    }

    private static void upload(String baseUrl, String body, String authentication, Credentials credentials) throws IOException {
        System.out.println(body);
        Request request;
        if (Reporter.authentication.basic.name().equalsIgnoreCase(authentication)) {
            String auth = credentials.getUsername() + ":" + credentials.getPassword();
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            request = new Request.Builder()
                    .url(baseUrl + "/rest/raven/1.0/import/execution")
                    .header(HttpHeaders.AUTHORIZATION, authHeader)
                    .post(RequestBody.create(body, JSON))
                    .build();
        } else {
            request = new Request.Builder()
                    .url(baseUrl + "/rest/raven/1.0/import/execution")
                    .post(RequestBody.create(body, JSON))
                    .build();
        }
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println(String.format("Failed to uploaded test execution to Jira Xray %s", response.body().string()));
            } else {
                System.out.println(String.format("Successfully uploaded test execution to Jira Xray"));
            }
        }
    }

    private static void authenticate(String baseUrl, String body) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + "/rest/auth/latest/session")
                .post(RequestBody.create(body, JSON))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException(String.format("Failed to authenticate with Jira %s", response.body().string()));
            }
        }
    }

}
