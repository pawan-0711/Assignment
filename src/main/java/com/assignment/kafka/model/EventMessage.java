package com.assignment.kafka.model;

public class EventMessage {

    private Info info;

    public EventMessage(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "info=" + info +
                '}';
    }

    public EventMessage() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
