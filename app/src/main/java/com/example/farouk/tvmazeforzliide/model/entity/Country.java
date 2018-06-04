package com.example.farouk.tvmazeforzliide.model.entity;

/**
 * Created by farouk on 03/06/2018.
 */

public class Country {
    /**
     * name : United States
     * code : US
     * timezone : America/New_York
     */

    private String name;
    private String code;
    private String timezone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
