package com.PriceEngine.CycleScenario;

import java.util.Scanner;

public class Main {
    //Default configuration
    public static String dateString;
    public static String cycleName;
    public static String frameMaterial;
    private static String seatingType;
    private static String handleBarType;
    private static int noOfGear;
    private static String tyreType;

    public static CycleImplementation cycleImpl = new CycleImplementation();

    public static Scanner in = new Scanner(System.in);

    public static void main(String args[]){
       getInput(); //get the input from command line

       cycleImpl.calculateCyclePrice(cycleName,dateString,frameMaterial,seatingType,handleBarType,noOfGear,tyreType);
    }

    /*
        Description : Get the inputs from command line
     */
    public static void getInput(){
        System.out.println("Enter Cycle Name for which price has to be calculated: ");
        cycleName = in.nextLine();
        System.out.println("Enter date price in format [yyyy-mm-dd]: ");
        dateString = in.nextLine();
        System.out.println("Enter Frame material for cycle [Steel/Aluminium]: ");
        frameMaterial = in.nextLine();
        System.out.println("Enter Seating type of cycle [Racing saddles/Comfort saddles]: ");
        seatingType = in.nextLine();
        System.out.println("Enter HandleBar type of cycle [Flat bars/Riser bars/Drop bars]: ");
        handleBarType = in.nextLine();
        System.out.println("Enter Tyre type of cycle [Tubed/Tubeless]: ");
        tyreType = in.nextLine();
        try {
            System.out.println("Enter Number of gears [In Number]: ");
            noOfGear = in.nextInt();
        }catch(Exception e){
            System.out.println("Input for gear should be integer");
        }
    }

}
