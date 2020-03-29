package com.rebelity.rebelityterminal.models;

public class SalesModel {
    private int         id;
    private String[]    tickets;
    private String      customer;
    private float       total_price;
    private String      pay_type;
    private String      time;

    public SalesModel(int id, String[] tickets, String customer, float total_price, String pay_type, String time) {
        this.id = id;
        this.tickets = tickets;
        this.customer = customer;
        this.total_price = total_price;
        this.pay_type = pay_type;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String[] getTickets() {
        return tickets;
    }

    public String getCustomer() {
        return customer;
    }

    public float getTotalPrice() {
        return total_price;
    }

    public String getPayType() {
        return pay_type;
    }

    public String getTime() {
        return time;
    }
}
