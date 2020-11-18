package com.PriceEngine.ThreadImplementation;

import com.PriceEngine.Cycle.ChainAssembly.ChainAssembly;
import com.PriceEngine.Cycle.Cycle;
import com.PriceEngine.Cycle.Frame.Frame;
import com.PriceEngine.Cycle.HandleBarWithBrake.HandleBar;
import com.PriceEngine.Cycle.Seating.Seating;
import com.PriceEngine.Cycle.Wheel.Wheel;
import com.PriceEngine.CycleScenario.Validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CycleThreadImpl {

    private Validation validate = new Validation();
    Date dateOfPricing;

    /*
        Description: Calculates the price of cycle for given configuration and Date of pricing
     */
    public double calculateCyclePrice(String cycleName,String dateString, String frameMaterial, String seatingType,
                                      String handleBarType, int noOfGear, String tyreType,String color){
        double price = 0.0;
        dateOfPricing = parseDate(dateString);

        if(validate.validateFrameMaterial(frameMaterial) && validate.validateHandleBarType(handleBarType)
                && validate.validateSeatingType(seatingType) && validate.validateTyreType(tyreType)
                && validate.validateGear(noOfGear)){

            Frame frame = new Frame(frameMaterial,dateOfPricing);
            ChainAssembly chainAssembly = new ChainAssembly(noOfGear);
            Seating seating = new Seating(seatingType);
            HandleBar handleBar = new HandleBar(handleBarType);
            Wheel wheel = new Wheel(tyreType,dateOfPricing);

            Cycle cycle1 = new Cycle(cycleName,frame,chainAssembly,seating,handleBar,wheel);
            price = cycle1.calculatePrice();

            System.out.println(color+Thread.currentThread().getName()+" Running: "+ cycleName + " Configuration: ");
            System.out.println("[FrameMaterial = '"+frameMaterial+"', SeatingType = '"+seatingType+"', HandleBar Type = '"+ handleBarType+
                            "', Number of Gear = '"+noOfGear+ "', Tyre Type = '"+ tyreType+ "'] ");
            System.out.println("Price of "+ cycleName+" : "+price);
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
