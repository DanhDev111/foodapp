package com.foodapplication;

public class SanPham {

    int id;
    String thumbnail;
    String name;
    int quantity;
    double cost;

    public SanPham() {

    }

    public SanPham(int id, String thumbnail, String name, int quantity, double cost) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public SanPham(String thumbnail, String name, int quantity, double cost) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}


