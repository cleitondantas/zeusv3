package br.com.rocketdevelopment.config;

import br.com.rocketdevelopment.model.UserPass;


public class BasicConfig {

    private String url;
    private String username;
    private String password;

    public BasicConfig() {
    }

    public BasicConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void addUrl(String url) {
        this.url = url;
    }
    public void addUsername(String username) {
        this.username = username;
    }
    public void addPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public UserPass getUserPass() {
        return new UserPass(username, password);
    }
}
