package org.gauge.xray;

public class Credentials {

    private String tokenOrPassword;

    private String username;

    public Credentials(String username, String tokenOrPassword) {
        this.username = username;
        this.tokenOrPassword = tokenOrPassword;
    }

    public String getCredentials() {
        return username + ":" + tokenOrPassword;
    }

}