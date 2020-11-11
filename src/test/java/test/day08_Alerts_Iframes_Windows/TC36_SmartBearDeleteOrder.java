package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC36_SmartBearDeleteOrder {
    /*
   TC #36: SmartBear delete order
1. Open browser and
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.login to SmartBear
4. Delete “Mark Smith” from the list
5. Assert it is deleted from the list
     */

   static  WebDriver driver;

   @BeforeMethod
    public void setup(){

       driver = WebDriverFactory.getDriver("chrome");

       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   }

   @Test
    public void smartBearDeleteOrder_test(){

      SmartBearUtilities.loginToSmartBear(driver);

      //Delete “Mark Smith” from the list
      WebElement markSmith = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[3]/td[1]"));

      markSmith.click();

      WebElement deleteButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']"));

      deleteButton.click();

    List<WebElement> namesWebElement = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

    List<String> customerNamesList = new ArrayList<>();

    for (WebElement each: namesWebElement){

          customerNamesList.add(each.getText());
    }

      System.out.println("customerNamesList = " + customerNamesList);


      String nameDeleted = "Mark Smith";

      Assert.assertTrue(! customerNamesList.contains(nameDeleted));

      //Assert it is deleted from the list
      if(! customerNamesList.contains(nameDeleted)){

         System.out.println("Mark Smith is not on the list.Verification pass!");

      }else{

         System.out.println("Mark Smith is on the list.Verification fail!");

      }


   }

   @AfterMethod
   public void teardown(){

      driver.close();
   }


}
