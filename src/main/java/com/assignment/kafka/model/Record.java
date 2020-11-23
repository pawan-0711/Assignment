package com.assignment.kafka.model;


public class Record {
    public Record(String eventSource, String eventTime, String eventName, String eventType, EventMessage eventMessage, EventError eventError) {
        this.eventSource = eventSource;
        this.eventTime = eventTime;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventMessage = eventMessage;
        this.eventError = eventError;
    }

    public Record() {
    }

    private String eventSource;
    private String eventTime;
    private String eventName;
    private String eventType;
    private EventMessage eventMessage;
    private EventError eventError;

    @Override
    public String toString() {
        return "Record{" +
                "eventSource='" + eventSource + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventMessage=" + eventMessage +
                ", eventError=" + eventError +
                '}';
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EventMessage getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(EventMessage eventMessage) {
        this.eventMessage = eventMessage;
    }

    public EventError getEventError() {
        return eventError;
    }

    public void setEventError(EventError eventError) {
        this.eventError = eventError;
    }
}
