package com.PriceEngine.Cycle;


import com.PriceEngine.Cycle.ChainAssembly.ChainAssembly;
import com.PriceEngine.Cycle.Frame.Frame;
import com.PriceEngine.Cycle.HandleBarWithBrake.HandleBar;
import com.PriceEngine.Cycle.Seating.Seating;
import com.PriceEngine.Cycle.Wheel.Wheel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/*
    Decription : Junit Test for the Cycle class, validates price of cycle and components for a given input
 */
class CycleTest {

    public  Date dateOfPricing;
    public String cycleName;
    public String frameMaterial;
    private  String seatingType;
    private  String handleBarType;
    private  int noOfGear;
    private  String tyreType;

    private Cycle cycle;
    Frame frame;
    ChainAssembly chainAssembly;
    Seating seating;
    HandleBar handleBar;
    Wheel wheel;


    /*
        Decription : Initialize configuration for cycle before running a method
    */
    @BeforeEach
    public void setup(){
        cycleName = "Cycle 1";
        frameMaterial = "Steel";
        seatingType = "Racing Saddles";
        handleBarType = "Flat Bars";
        noOfGear = 4;
        tyreType = "Tubeless";
        try {
            dateOfPricing = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14");
        } catch (ParseException e) {
            dateOfPricing = null;
        }

        frame = new Frame(frameMaterial,dateOfPricing);
        chainAssembly = new ChainAssembly(noOfGear);
        seating = new Seating(seatingType);
        handleBar = new HandleBar(handleBarType);
        wheel = new Wheel(tyreType,dateOfPricing);

        cycle = new Cycle(cycleName,frame,chainAssembly,seating,handleBar,wheel);
    }

    /*
        Description: Verify the Price calculated of Cycle
     */
    @Test
    public void validatePrice() throws Exception {
        //validate Price of cycle for given configuration
        double expectedCyclePrice = cycle.calculatePrice();
        assertEquals(5970.00,expectedCyclePrice,0);

        //validate Frame price for given input
        double expectedFramePrice = frame.getPriceOfFrame();
        assertEquals(700.0,expectedFramePrice,0);

        //validate Seat price for given input
        double expectedSeatPrice = seating.getPriceOfSeat();
        assertEquals(1000.0,expectedSeatPrice,0);

        //validate price for 4 gears
        double expectedGearPrice = chainAssembly.getTotalPrice();
        assertEquals(80.0,expectedGearPrice,0);

        //validate HandleBar price for given input
        double expectedHandleBarPrice = handleBar.getPriceOfHandleBar();
        assertEquals(3050.0 ,expectedHandleBarPrice,0);

        //validate price for one wheel with tubeless tyre
        double expectedWheelPrice = wheel.getPriceOfWheel();
        assertEquals(570.0,expectedWheelPrice,0);

    }

}