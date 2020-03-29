package com.rebelity.rebelityterminal.models;

public class GuestsModel {
    private int         id;
    private String      name;
    private String[]    tickets;
    private boolean     phone_verified;
    private boolean     email_verified;
    private boolean     status;

    public GuestsModel(int id, String name, String[] tickets, boolean phone_verified, boolean email_verified, boolean status) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
        this.phone_verified = phone_verified;
        this.email_verified = email_verified;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String[] getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }
}
