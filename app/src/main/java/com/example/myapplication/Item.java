package com.example.myapplication;

public class Item {
    private String descriotion;
    private int resid; // image id to be loaded
    private boolean isHappy;
    private int amount;
    //Constructor
    public Item(String descriotion, int resid, boolean isHappy, int amount) {
        this.descriotion = descriotion;
        this.resid = resid;
        this.isHappy = isHappy;
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

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
