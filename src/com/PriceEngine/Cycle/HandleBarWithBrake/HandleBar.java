package com.PriceEngine.Cycle.HandleBarWithBrake;

/*
    Description : Represents HandleBar with brake component of Cycle module
 */
public class HandleBar {
    private String type;
    private double priceOfHandleBar;
    private Brake breakObj;

    public HandleBar(String type) {
        this.type = type;
        this.priceOfHandleBar = 0.0;
        this.breakObj = new Brake();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceOfHandleBar() {
        return priceOfHandleBar;
    }

    public void setPriceOfHandleBar(double priceOfHandleBar) {
        this.priceOfHandleBar = priceOfHandleBar;
    }


    @Override
    public String toString(){
        return "Price of HandleBar of '"+this.type+"' type with Brake is : "+this.priceOfHandleBar;
    }

    /*
        Description : Calculates price of Handle bar based on type, along with break price
     */
    public double calculatePrice(){
        if(type.equalsIgnoreCase("flat bars")){

            this.priceOfHandleBar = breakObj.getPriceOfBreak() + 3000;

        }else if(type.equalsIgnoreCase("riser bars")){

            this.priceOfHandleBar = breakObj.getPriceOfBreak() + 2000;

        }else if(type.equalsIgnoreCase("drop bars")){

            this.priceOfHandleBar = breakObj.getPriceOfBreak() + 1000;

        }
        return this.priceOfHandleBar;
    }

}
