package com.rebelity.rebelityterminal.models;

public class TicketModel {
    private int     id;
    private String  name;
    private int     quantity;
    private float   price;

    public TicketModel(int id, String name, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
}
