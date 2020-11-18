package com.PriceEngine.Cycle.HandleBarWithBrake;

/*
    Description : Represents Brake
 */
public class Brake {

    private double priceOfBreak;

    /*
        Description : Initialize price of brake with default value
    */
    public Brake() {
        this.priceOfBreak = 50;
    }

    public double getPriceOfBreak() {
        return priceOfBreak;
    }

    public void setPriceOfBreak(double priceOfBreak) {
        this.priceOfBreak = priceOfBreak;
    }
}
