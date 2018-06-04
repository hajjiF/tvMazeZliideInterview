package com.example.farouk.tvmazeforzliide.model.entity;

import java.util.List;

/**
 * Created by farouk on 03/06/2018.
 */

public class Schedule {
    /**
     * time : 22:00
     * days : ["Thursday"]
     */

    private String time;
    private List<String> days;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
