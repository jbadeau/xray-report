package org.gauge.xray.client;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import org.gauge.xray.Credentials;


import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class XrayClient {

    private static Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();

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

    public XrayClient(String baseUrl, Credentials credentials) {
        this.baseUrl = baseUrl;
        this.credentials = credentials;
    }

    public Response importExecution(String body) throws IOException {
        Request request = getBaseRequestBuilder()
                .url(baseUrl + "/rest/raven/1.0/import/execution")
                .post(RequestBody.create(body, JSON))
                .build();
        return client.newCall(request).execute();
    }

    private Request.Builder getBaseRequestBuilder() throws IOException {
        return new Request.Builder()
                .header("Authorization", "Basic " + credentials.toBase64String())
                .header("Content-Type", "application/json");
    }


}