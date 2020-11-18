package com.PriceEngine.Cycle.Wheel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Description : Represents Tyre of wheel
 */
public class Tyre {
    private String type;
    private Date dateOfPricing;
    private double price;
    Date date = parseDate("2016-01-01");

    public Tyre(String type, Date dateOfPricing, double price) {
        this.type = type;
        this.dateOfPricing = dateOfPricing;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public Date getDateOfPricing(){
        return dateOfPricing;
    }

    public double getPrice() {
        return price;
    }

    /*
        Description : Parses and returns valid date for a given date string
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /*
        Description : Calculate price of tyre based on date [01/12/2016]
    */
    public double calculatePrice(){
        //If given date is before 01/12/2016
        if(dateOfPricing.before(date)){
            this.price += 300;
        }else if(dateOfPricing.after(date)){
            this.price += 400;
        }
        return this.price;
    }
}

