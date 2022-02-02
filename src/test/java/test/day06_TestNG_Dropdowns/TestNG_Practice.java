package test.day06_TestNG_Dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Practice {

    @BeforeClass
    public void before_class(){

        System.out.println("Before class runs only once before all tests in the class");
    }

    @AfterClass
    public void after_class(){

        System.out.println("After class makes the annotated method run only once after all the tests in the class");
    }

    @BeforeMethod
    public void setUp(){

        System.out.println("Before method is running before each test...");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("After method is running after each test...");

    }

    @Test
    public void test1(){

        System.out.println("Test 1 is running...");

        String actualTitle = "Homepage";//driver.getTitle();
        String expectedTitle = "Homepage";

        //Assert class comes from TestNG, helps us to verify actual vs expected results
        //all methods of Assert class are static, so we can call them thru class name
        Assert.assertEquals(actualTitle,expectedTitle);

        //so we dont need if else statements anymore

    }


    @Ignore //we can ignore/skip some tests we dont want to run
    @Test
    public void test2(){

        System.out.println("Test 2 is running...");

        Assert.assertEquals("string1", "string2", "String verification on test 2 failed");
        //it fails, because they are not matching, you can give one more arg as msg

    }


    @Test
    public void test3(){

        System.out.println("Test 3 is running...");

        String actualTitle = "Amazon prime";
        String expectedInTitle = "prime";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //we have to pass boolean value  into assertTrue() method, returns boolean

        String testValue = "u3o89qey";

        Assert.assertFalse(actualTitle.contains(testValue));
        //if the boolean value we pass in assertFalse() is false, then assertion will pass
        //else it will fail


    }




}
