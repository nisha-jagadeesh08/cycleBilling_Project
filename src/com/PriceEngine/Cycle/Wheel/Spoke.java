package com.PriceEngine.Cycle.Wheel;

/*
    Description : Represents Spoke of Wheel
 */
public class Spoke {
    private double pricePerSpoke;

    public Spoke() {
        this.pricePerSpoke = 10.00;
    }

    public double getPricePerSpoke() {
        return pricePerSpoke;
    }

    public void setPricePerSpoke(double pricePerSpoke) {
        this.pricePerSpoke = pricePerSpoke;
    }
}
