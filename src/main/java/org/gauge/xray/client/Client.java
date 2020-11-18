package org.gauge.xray.client;

import com.google.common.net.HttpHeaders;
import okhttp3.*;
import org.gauge.xray.Credentials;


import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Client {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient client;

    private String baseUrl;

    private Credentials credentials;

    static {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
    }

    public Client(String baseUrl, Credentials credentials) {
        this.baseUrl = baseUrl;
        this.credentials = credentials;
    }

    public void authenticate(String baseUrl, String body) throws IOException {
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

    public Response post(String body) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + "/rest/raven/1.0/import/execution")
                .header(HttpHeaders.AUTHORIZATION, getAuthorizationHeader())
                .post(RequestBody.create(body, JSON))
                .build();
        return client.newCall(request).execute();
    }

    private String getAuthorizationHeader() {
        byte[] encodedAuth = Base64.getEncoder().encode(credentials.getCredentials().getBytes(StandardCharsets.ISO_8859_1));
        return "Basic " + new String(encodedAuth);
    }

}