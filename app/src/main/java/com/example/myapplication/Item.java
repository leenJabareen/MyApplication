package com.example.myapplication;

public class Item {
    private String descriotion;
    private int resid; // image id to be loaded
    private double price ;
    private int amount;
    //Constructor
    public Item(String descriotion, int resid, double price, int amount) {
        this.descriotion = descriotion;
        this.resid = resid;
        this.price = price;
        this.amount = amount;
    }
    // Getters and settes
    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item(){

    }

}
