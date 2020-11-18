package com.PriceEngine.CycleScenario;

import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CycleImplementationTest {

    public String dateString;
    public String cycleName;
    public String frameMaterial;
    private  String seatingType;
    private  String handleBarType;
    private  int noOfGear;
    private  String tyreType;
    private double expected;

    private CycleImplementation cycleImpl;

    /*
        Decsription : Set the instance variables with the parameters provided
     */
    public CycleImplementationTest(String cycleName,String dateString, String frameMaterial, String seatingType,
                                   String handleBarType, int noOfGear, String tyreType, double expected) {
        this.dateString = dateString;
        this.cycleName = cycleName;
        this.frameMaterial = frameMaterial;
        this.seatingType = seatingType;
        this.handleBarType = handleBarType;
        this.noOfGear = noOfGear;
        this.tyreType = tyreType;
        this.expected = expected;
    }

    @Before
    public void setup(){
        cycleImpl = new CycleImplementation();
    }

    /*
        Description : Validate price of cycle for each configuration provided
     */
    @Test
    public void calculateCyclePrice() throws Exception {
        try {
            //validate Price of cycle for given configuration
            double actualPrice = cycleImpl.calculateCyclePrice(cycleName, dateString, frameMaterial,
                    seatingType, handleBarType, noOfGear, tyreType);
            assertEquals(expected, actualPrice, 0);

        }catch (IllegalArgumentException e){
            System.out.println("Invalid Argument :"+e.toString());
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }
    }

    /*
        Description : Provide set of parameters along with expected value for testing various configurations
     */

    @Parameterized.Parameters
    public static Collection<Object[]> testCondition(){
        return Arrays.asList(new Object[][] {
                {"Cycle1","2014-02-14","Steel","Racing saddles","Flat Bars",4,"Tubeless",5970.00},
                {"Cycle2","2016-01-01","Aluminium","Comfort saddles","Riser bars",3,"Tubed",4010.0},
                {"Cycle3","2018-02-09","Steel","Comfort saddles","Drop bars",4,"Tubeless",3670.0},
                {"Cycle4","2013-03-01","Aluminium","Racing saddles","Riser bars",5,"Tubeless",5090.0},
                {"Cycle5","2013-03-01","Dummy","Racing saddles","Riser bars",5,"Tubeless",0.0}, //negative scenario
                {"Cycle6","2013-03-01","Aluminium","Dummy saddles","Riser bars",5,"Tubeless",0.0},
                {"Cycle7","2013-03-01","Aluminium","Racing saddles","Dummmy bars",5,"Tubeless",0.0},
                {"Cycle8","2013-03-01","Aluminium","Racing saddles","Riser bars",5,"Dummy",0.0},
        });
    }
}