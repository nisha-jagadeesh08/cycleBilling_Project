package com.PriceEngine.CycleScenario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Validation {
    ArrayList<String> availableFrameMaterial = new ArrayList<String>();
    ArrayList<String> availableSeatingType = new ArrayList<String>();
    ArrayList<String> availableHandleBarType = new ArrayList<String>();
    ArrayList<String> availableTyreType = new ArrayList<String>();

    /*
        Decription : Intialize the arraylist with available options
     */

    public Validation() {
        //available frame materials
        availableFrameMaterial.add("steel");
        availableFrameMaterial.add("aluminium");

        //available seating types
        availableSeatingType.add("racing saddles");
        availableSeatingType.add("comfort saddles");

        //available Handle bar types
        availableHandleBarType.add("flat bars");
        availableHandleBarType.add("riser bars");
        availableHandleBarType.add("drop bars");

        //available tyre types
        availableTyreType.add("tubeless");
        availableTyreType.add("tubed");
    }

    /*
        Description : Print given Arraylist
     */
    public void printList(ArrayList<String> listAvailable) {
        for (String s : listAvailable) {
            System.out.println(s);
        }
    }

    /*
        Description : Validate Frame material, print available frame material if input in Invalid
     */
    public boolean validateFrameMaterial(String material) {
        material = material.toLowerCase();
        if (availableFrameMaterial.contains(material)) {
            return true;
        } else {
            System.out.println("Provided Frame material '" + material + "' is not available");
            System.out.println("Below are valid Frame materials available : ");
            printList(availableFrameMaterial);
            return false;
        }
    }

    /*
       Description : Validate Seating type, print available Seating type if input in Invalid
    */
    public boolean validateSeatingType(String type) {
        type = type.toLowerCase();
        if (availableSeatingType.contains(type)) {
            return true;
        } else {
            System.out.println("Provided Seating type '" + type + "' is not available");
            System.out.println("Below are valid Seating types available : ");
            printList(availableSeatingType);
            return false;
        }

    }

    /*
       Description : Validate Handlebar type, print available Handlebar type if input in Invalid
    */
    public boolean validateHandleBarType(String type) {
        type = type.toLowerCase();
        if (availableHandleBarType.contains(type)) {
            return true;
        } else {
            System.out.println("Provided HandleBar type '" + type + "' is not available");
            System.out.println("Below are valid HandleBar types available : ");
            printList(availableHandleBarType);
            return false;
        }
    }

    /*
       Description : Validate Tyre type, print available Tyre type if input in Invalid
    */
    public boolean validateTyreType(String type) {
        type = type.toLowerCase();
        if (availableTyreType.contains(type)) {
            return true;
        } else {
            System.out.println("Provided Tyre type '" + type + "' is not a valid");
            System.out.println("Below are valid Tyre types available : ");
            printList(availableTyreType);
            return false;
        }
    }

    /*
       Description : Validates gear input to be a int
    */
    public boolean validateGear(int n) {
        if (n > 0) {
            return true;
        } else {
            System.out.println("Cycle gear number cannot be zero");
            return false;
        }
    }

    /*
        Description : Validate date format
     */
    public boolean validateDate(Date dateOfPricing){
        try {
            if (dateOfPricing.equals(null)) {
                System.out.println("Invalid date or Date Format. " +
                        "Please Enter a valid date in 'yyyy-mm-dd' format");
                return false;
            } else {
                return true;
            }
        }catch(Exception e){
            System.out.println("Invalid date or Date Format. " +
                    "Please Enter a valid date in 'yyyy-mm-dd' format");
            return false;
        }
    }

}