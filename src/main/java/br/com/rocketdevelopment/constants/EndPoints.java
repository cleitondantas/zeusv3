package br.com.rocketdevelopment.constants;

public enum EndPoints {

    LOGIN("/cgi-bin/api/v3/system/login"),
    LED("/cgi-bin/api/v3/service/leds"),
    STATUS("/cgi-bin/api/v3/system/status"),
    WIRELESS_ADVERTISING("/cgi-bin/api/v3/interface/wireless/advertising");
    private final String url;

    EndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
