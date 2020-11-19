package org.gauge.xray;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Credentials {

    private String username;

    private String token;

    public Credentials(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String toBase64String() {
        String auth = username + ":" + token;
        return Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
    }

}