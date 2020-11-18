package com.PriceEngine.Cycle.Seating;

/*
    Description : Represents Seating component of Cycle module
 */
public class Seating {
    private String type;
    private double priceOfSeat;

    public Seating(String type) {
        this.type = type;
        this.priceOfSeat = 0.0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceOfSeat() {
        return priceOfSeat;
    }

    public void setPriceOfSeat(double priceOfSeat) {
        this.priceOfSeat = priceOfSeat;
    }

    @Override
    public  String toString(){
        return "Price of Seating of type '"+this.type+"' is :"+this.priceOfSeat;
    }

    /*
        Description : Calculate price of spoke based on type
    */
    public double calculatePrice(){
        if(type.equalsIgnoreCase("racing saddles")){
            this.priceOfSeat = 1000;
        }else if(type.equalsIgnoreCase("comfort saddles")){
            this.priceOfSeat = 500;
        }
        return this.priceOfSeat;
    }

}
