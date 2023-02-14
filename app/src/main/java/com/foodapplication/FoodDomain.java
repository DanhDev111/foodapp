package com.foodapplication;

public class FoodDomain {
    String title;
    String pic;
    String descript;
    Double cost;
    int numberInCart;
    public FoodDomain() {
    }

    public FoodDomain(String title, String pic, String descript, Double cost) {
        this.title = title;
        this.pic = pic;
        this.descript = descript;
        this.cost = cost;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}

