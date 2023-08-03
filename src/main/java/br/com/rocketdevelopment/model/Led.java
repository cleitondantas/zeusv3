package br.com.rocketdevelopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Led {
    @JsonProperty("enabled")
    private boolean enabled;
    private boolean search;
    private boolean active;
    @JsonProperty("color")
    private Color color;
    @JsonProperty("days_of_week")
    private DaysOfWeek days_of_week;
    @JsonProperty("intervals")
    private List<Interval> intervals;
    @JsonProperty("action")
    private Action action;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DaysOfWeek getDays_of_week() {
        return days_of_week;
    }

    public void setDays_of_week(DaysOfWeek days_of_week) {
        this.days_of_week = days_of_week;
    }


    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
