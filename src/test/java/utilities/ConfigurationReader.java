package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //  -> to be able to read from .properties type of file, we have to do some setup.
    //   -> step by step how to read from properties file:

    //1- we created properties object of Properties class
    private static Properties properties = new Properties();

    static{//static block runs once and before everything else

        //2- we get the path and store in String , or directly pass into fileInputStream object
        String path = "configuration.properties";

         try{//we need to try/catch the IOException which FileInputStream file is throwing

             //3- We need to OPEN the file in JVM memory
             FileInputStream file = new FileInputStream(path);

             //4- we need to load the file to properties object.
             properties.load(file);

             //5- close file previously opened file
             file.close();

         }catch (IOException exception){

             System.out.println("Properties file not found!");

         }
    }

    //our own custom method to read and get values from configuration.properties file
    public static String  getProperty(String keyWord){

        //getProperty() method comes from Java itself, from Properties class
        return properties.getProperty(keyWord);

    }


}



