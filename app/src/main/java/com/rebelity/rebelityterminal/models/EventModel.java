package com.rebelity.rebelityterminal.models;

public class EventModel {
    private int     id;
    private String  event;
    private String  instance;
    private String  contact;

    public EventModel(int id, String event, String instance, String contact) {
        this.id = id;
        this.event = event;
        this.instance = instance;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getInstance() {
        return instance;
    }

    public String getContact() {
        return contact;
    }
}
