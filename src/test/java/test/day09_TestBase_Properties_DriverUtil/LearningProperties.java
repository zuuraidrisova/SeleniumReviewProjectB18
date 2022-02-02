package test.day09_TestBase_Properties_DriverUtil;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void learningProperties_test(){

        //.getProperty(Key) ==> is accepting a key and returns its value

        //properties type of file store value in key and value format

        //key=value
        //name=john
        //browser=chrome

        System.out.println( "System Properties: " + System.getProperty("os.name"));

        System.out.println( "System Username: "+ System.getProperty("user.name"));

        System.out.println("System Password: "+System.getProperty("password.name"));

    }

}
