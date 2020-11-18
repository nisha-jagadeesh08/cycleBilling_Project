package com.PriceEngine.Cycle.Frame;

import java.util.Date;

/*
    Description : Represents Frame component of Cycle module
 */
public class Frame {

    private String material;
    private Date dateOfPricing;
    private double priceOfFrame;
    private Date date = new Date(2017,12,01);


    public Frame(String material, Date dateOfPricing) {
            this.material = material;
            this.dateOfPricing = dateOfPricing;
            this.priceOfFrame = 0.0;
    }

    public String getType() {
        return material;
    }

    public void setType(String type) {
        this.material = type;
    }

    public double getPriceOfFrame() {
        return priceOfFrame;
    }

    public String toString(){
        return "Price of Frame of '"+this.material+"' type is: "+this.priceOfFrame;
    }

    /*
        Description : Calculates price of frame
    */
    public double calculatePriceOfFrame(){
        //If given date is before 01/12/2017
        if(dateOfPricing.before(date)){
            priceOfFrame = 300;
        }else if(dateOfPricing.after(date)){
            priceOfFrame = 400;
        }

        if(this.material.equalsIgnoreCase("steel")){
            priceOfFrame += 400;
        }else if (this.material.equalsIgnoreCase("aluminium")){
            priceOfFrame += 500;
        }
        return this.priceOfFrame;
    }
}
