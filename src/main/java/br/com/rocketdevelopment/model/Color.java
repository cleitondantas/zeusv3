package br.com.rocketdevelopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Color {

    private String value;

    @JsonProperty("option_list")
    private List<String> optionList;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }
}
