package com.PriceEngine.Cycle.ChainAssembly;

/*
    Description : Represents Chain assembly component of Cycle module
 */
public class ChainAssembly {
    private int noOfGear;
    private double totalPrice;

    public ChainAssembly(int noOfGear) {
        this.noOfGear = noOfGear;
        this.totalPrice = 0.0;
    }

    public int getNoOfGear() {
        return noOfGear;
    }

    public void setNoOfGear(int noOfGear) {
        this.noOfGear = noOfGear;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /*
        Description : Calculates price of Chain assembly
    */
    public double calculatePrice(){
        this.totalPrice = this.noOfGear * 20;
        return  this.totalPrice;
    }

    public String toString(){
        return "Price of '"+this.noOfGear+"' Gears is : "+this.totalPrice;
    }
}
