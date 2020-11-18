package com.PriceEngine.CycleScenario;

import com.PriceEngine.Cycle.ChainAssembly.ChainAssembly;
import com.PriceEngine.Cycle.Cycle;
import com.PriceEngine.Cycle.Frame.Frame;
import com.PriceEngine.Cycle.HandleBarWithBrake.HandleBar;
import com.PriceEngine.Cycle.Seating.Seating;
import com.PriceEngine.Cycle.Wheel.Wheel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CycleImplementation {
    private Validation validate = new Validation();
    Date dateOfPricing;
    String cycleName = "Cycle 1";

    /*
        Description: Validate given configuration for cycle,
         Calculate price of cycle for a given configuration and date of pricing
     */
    public double calculateCyclePrice(String cycleName,String dateString, String frameMaterial, String seatingType,
                                          String handleBarType, int noOfGear, String tyreType){
        double price = 0.0;
        dateOfPricing = parseDate(dateString);

        if(validate.validateDate(dateOfPricing) && validate.validateFrameMaterial(frameMaterial)
                && validate.validateHandleBarType(handleBarType) && validate.validateSeatingType(seatingType)
                && validate.validateTyreType(tyreType) && validate.validateGear(noOfGear)){

            Frame frame = new Frame(frameMaterial,dateOfPricing);
            ChainAssembly chainAssembly = new ChainAssembly(noOfGear);
            Seating seating = new Seating(seatingType);
            HandleBar handleBar = new HandleBar(handleBarType);
            Wheel wheel = new Wheel(tyreType,dateOfPricing);

            Cycle cycle1 = new Cycle(cycleName,frame,chainAssembly,seating,handleBar,wheel);
            price = cycle1.calculatePrice();
            System.out.println("**************************************************");
            System.out.println(cycle1);
            System.out.println("Price of components of '"+cycleName+"' for Date: "+ dateString);
            System.out.println("***************************************************");
            cycle1.printComponentPrice(); //print component price
            System.out.println("***************************************************");
            System.out.println("");

        }else {
            System.out.println("Price of cycle '"+cycleName+"' is not calculated due to invalid inputs");
        }

        return price;
    }

    /*
        Description: Parse given string to Date type and return a valid Date
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}
