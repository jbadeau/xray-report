package org.gauge.xray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.gauge.Messages.Message;
import com.thoughtworks.gauge.Messages.SuiteExecutionResult;
import okhttp3.*;
import org.gauge.xray.client.XrayClient;
import org.gauge.xray.model.Report;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Reporter {

    private static final String LOCALHOST = "127.0.0.1";

    private static XrayClient client;

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

                    String jiraUrl = getProperty("jira_url", true);
                    String jiraToken = getProperty("jira_token", true);

                    Credentials credentials = new Credentials(jiraToken, jiraToken);

                    client = new XrayClient(jiraUrl, credentials);

                    String jiraTestExecutionId = getProperty("jira_test_execution_id", true);
                    String jiraTestExecutionSummary = getProperty("jira_test_execution_summary", false);

                    List<Report> reports = ReportBuilder.build(result, jiraTestExecutionId, jiraTestExecutionSummary);
                    Gson gson = new GsonBuilder()
                            .disableHtmlEscaping()
                            .setPrettyPrinting()
                            .create();

                    System.out.println(String.format("Uploading %d test execution(s) to Jira Xray...", reports.size()));

                    for (Report report : reports) {
                        uploadReport(gson.toJson(report));
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

    private static void uploadReport(String body) throws IOException {
        Response response = client.importExecution(body);
        if (!response.isSuccessful()) {
            System.out.println(String.format("Successfully uploaded test execution to Jira Xray"));
        } else {
            System.err.println(String.format("Failed to uploaded test execution to Jira Xray %s", response.body().string()));
        }
    }

    private static String getProperty(String name, boolean required) {
        String value = System.getenv(name);
        if (value == null && required) {
            throw new RuntimeException(String.format("Missing required environment property %s", name));
        }
        return value;
    }

}
