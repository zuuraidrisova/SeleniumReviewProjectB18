package test.day05_Recap_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGClass {

    /*
    TestNg ==> NG ==> stands for next generation

    @Test ==> annotation,indicates that method is a test method.
    Test method where we do assertions
     */

    @BeforeMethod
    public void setUp(){
        //@BeforeMethod annotation will always run once before every @Test method
        //u declare and write it just once, but it will run however many times u have @Test in class

        System.out.println("Before Method running...");
    }

    @Test
    public void test1(){

        System.out.println("Test 1 is running...");

    }

    @Test
    public void test2(){

        System.out.println("Test 2 is running ...");

    }

    @AfterMethod
    public void tearDown(){

//@AfterMethod annotation will always run once after every @Test method
        System.out.println("After method running...");
    }
}
