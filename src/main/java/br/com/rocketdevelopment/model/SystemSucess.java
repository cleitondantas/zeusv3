package br.com.rocketdevelopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemSucess {

    private boolean success;
    private boolean sucess;
    @JsonProperty("config_hash")
    private String configHash;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getConfigHash() {
        return configHash;
    }

    public void setConfigHash(String configHash) {
        this.configHash = configHash;
    }
}
