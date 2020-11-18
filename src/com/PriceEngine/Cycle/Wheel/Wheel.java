package com.PriceEngine.Cycle.Wheel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
    Description : Represents Wheel component of Cycle
 */
public class Wheel {
    private int noOfSpokes;
    private double priceOfWheel;
    Spoke spoke;
    Rim rim;
    Tyre tyre;

    /*
        Description : Initialize with initial values
     */
    public Wheel(String tyreType, Date dateOfPricing) {
        this.noOfSpokes = 24; //assumption as default
        this.spoke = new Spoke();
        this.rim = new Rim();

        //if Tyre type is tubeless, do not calculate tube price
        if(tyreType.equalsIgnoreCase("tubeless")){
            this.tyre = new Tyre(tyreType,dateOfPricing,0);
        }else if(tyreType.equalsIgnoreCase("tubed")){
            Tube tube = new Tube();
            this.tyre = new Tyre(tyreType,dateOfPricing,tube.getPrice()); //pass tube price if tyre is 'Tubed'
        }
    }

    public int getNoOfSpokes() {
        return noOfSpokes;
    }

    public void setNoOfSpokes(int noOfSpokes) {
        this.noOfSpokes = noOfSpokes;
    }

    public double getPriceOfWheel(){
        return this.priceOfWheel;
    }

    public String toString(){
        return "Price of Wheel with Tyre of type '"+tyre.getType()+"' is: "+this.priceOfWheel;
    }

    /*
        Description : Calculate price of wheel
    */

    public double calculatePrice(){
        this.priceOfWheel = spoke.getPricePerSpoke() * noOfSpokes + tyre.calculatePrice() + rim.getPrice() ;
        return this.priceOfWheel;
    }

}
