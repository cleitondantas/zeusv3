package br.com.rocketdevelopment.model;

import java.util.List;

public class Action {
    private String value;

    private List<String> option_list;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getOption_list() {
        return option_list;
    }

    public void setOption_list(List<String> option_list) {
        this.option_list = option_list;
    }
}
