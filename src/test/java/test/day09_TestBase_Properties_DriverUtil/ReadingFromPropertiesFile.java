package test.day09_TestBase_Properties_DriverUtil;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromPropertiesFile {

    @Test
    public void readingFromProperties() throws IOException {

        //Properties class object allows us to read from configuration.properties
        Properties properties = new Properties();

        //We need to show where the file is stored: we need the path of the file
        //content root path or relative path
        String path = "configuration.properties";

        //We need to open this configuration.properties file in java memory
        FileInputStream file = new FileInputStream(path);
        //FileInputStream file throws Unhandled exception:IOException

        //we need to load the opened file into the properties object
        properties.load(file);


        //we can read the configuration.properties file
        // using properties object and getProperty() method

        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));



    }

    @Test
    public void using_configurationReader_utility(){

        //now all we have to do is to use our static custom method getProperty()
        // thru class name to be able to read from configuration.properties file

        String browser = ConfigurationReader.getProperty("browser");
        System.out.println("browser = " + browser);

        String username = ConfigurationReader.getProperty("username");
        System.out.println("username = " + username);

        String password = ConfigurationReader.getProperty("password");
        System.out.println("password = " + password);

    }


}
