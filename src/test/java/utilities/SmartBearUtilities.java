package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    /*
    Mini-Task:•Create a method called loginToSmartBear
    •This method simply logs in to SmartBear when you call it.
    •Accepts WebDriver type as parameter
     */

    public static void loginToSmartBear(WebDriver driver){

        //locating all input boxes to enter credentials
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));


        //entering credentials and clicking the login button
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();

    }


       /*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    public static void verifyOrder(WebDriver driver, String expectedName){

        //we have to locate all names and store them in list
        List<WebElement> listOfAllNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        String actualName = "";//to store our actual value

        for (WebElement eachName :  listOfAllNames){//loop thru all web elements in list

            if(eachName.getText().equals(expectedName)) {
                //to check if each Name is equal to expected name

                actualName += eachName.getText();//if equal, concate it to actual Name
            }

        }

        Assert.assertTrue(actualName.equals(expectedName));

    }

       /*
    Practice #5: Method: printNamesAndCities
• Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city
     */
    public static void printNamesAndCities(WebDriver driver){

        //locating names web elements and storing them in list
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        //locating cities web elements and storing them in list
        List<WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));

        for (int i = 0; i < listOfNames.size(); i++){


            System.out.println("Name "+ (i+1) +" "+ listOfNames.get(i).getText()+", City "+(i+1)+" "+listOfCities.get(i).getText());

        }

    }





}
