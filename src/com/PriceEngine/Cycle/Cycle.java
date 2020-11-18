package com.PriceEngine.Cycle;

import com.PriceEngine.Cycle.ChainAssembly.ChainAssembly;
import com.PriceEngine.Cycle.Frame.Frame;
import com.PriceEngine.Cycle.HandleBarWithBrake.HandleBar;
import com.PriceEngine.Cycle.Seating.Seating;
import com.PriceEngine.Cycle.Wheel.Wheel;

/*
    Description : Represents Cycle module
 */
public class Cycle {
    private String name;
    private double priceOfCycle;
    private Frame frame;
    private ChainAssembly chainAssembly;
    private Seating seating;
    private HandleBar handleBar;
    private Wheel wheel;

    public Cycle(String name, Frame frame, ChainAssembly chainAssembly, Seating seating,
                 HandleBar handleBar, Wheel wheel) {
        this.name = name;
        this.priceOfCycle = 0.0;
        this.frame = frame;
        this.chainAssembly = chainAssembly;
        this.seating = seating;
        this.handleBar = handleBar;
        this.wheel = wheel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceOfCycle() {
        return priceOfCycle;
    }

    public Frame getFrame() {
        return frame;
    }

    public ChainAssembly getChainAssembly() {
        return chainAssembly;
    }

    public Seating getSeating() {
        return seating;
    }

    public HandleBar getHandleBar() {
        return handleBar;
    }

    public Wheel getWheel() {
        return wheel;
    }

    @Override
    public String toString(){
        return "Price of Cycle '"+ this.name +"' is: "+this.priceOfCycle;
    }

    /*
        Decription : Print component price
     */
    public void printComponentPrice(){

        System.out.println(frame);
        System.out.println(chainAssembly);
        System.out.println(seating);
        System.out.println(handleBar);
        System.out.println(wheel);
    }

    /*
        Decription : Calulates price of cycle
     */
    public double calculatePrice(){
        this.priceOfCycle = frame.calculatePriceOfFrame()+chainAssembly.calculatePrice()+
                seating.calculatePrice()+ handleBar.calculatePrice()+wheel.calculatePrice()*2;
        return this.priceOfCycle;
    }
}
