package test.day07_WebTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC28_SmartBearSoftwareOrderPlacing {

      /*
    TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”
     */

    WebDriver driver; //we put our driver at class level so it is accessible anywhere in the class

    @BeforeMethod
    public void setUp(){

        //sets up the driver, opens chrome browser, connects Selenium code and browser,
        driver = WebDriverFactory.getDriver("chrome");

        //makes window fullscreen
        driver.manage().window().maximize();

        //waits until whole page is loaded
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //goes to given url and opens it in an open browser
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void smartBearOrderPlacing_verification() throws InterruptedException{

        //locating all input boxes to enter credentials
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        //entering credentials and clicking the login button
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();

        Thread.sleep(1000);//waits one second to stop the session

        // Locating and Clicking on Order
        WebElement order = driver.findElement(By.linkText("Order"));

        order.click();

        Thread.sleep(1000);

        //Select familyAlbum from product, set quantity to 2
        WebElement productSelection = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));

        //use Select class from Selenium to handle select dropdowns
        Select selectFamilyAlbum = new Select(productSelection);

        //selecting family album by value
        selectFamilyAlbum.selectByValue("FamilyAlbum");

        Thread.sleep(1000);

        //Locating and Setting the quantity
        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));

        //quantity.clear();

        //first we have to get rid of default value which is 0 by using keyboard manipulations
        quantity.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(1000);

        quantity.sendKeys("2");

        //Locating and Clicking to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));

        calculateButton.click();

        Thread.sleep(1000);

       //Locating all customer information inputs
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));

        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));

        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));

        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));

        //Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();//we have to create an instance of java faker to generate random data

        customerName.sendKeys(faker.name().fullName());

        Thread.sleep(1000);

        street.sendKeys(faker.address().streetAddress());

        Thread.sleep(1000);

        city.sendKeys(faker.address().city());

        Thread.sleep(1000);

        state.sendKeys(faker.address().state());

        Thread.sleep(1000);

        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        Thread.sleep(1000);

       // Locating  and  Clicking  on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));

        visaRadioButton.click();

        Thread.sleep(1000);

        //Locating card info and Generate card number using JavaFaker
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));

        cardNumberInput.sendKeys(faker.business().creditCardNumber().replaceAll("-",""));

        Thread.sleep(1000);

        WebElement expireDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));

        expireDate.sendKeys("10/28");

        Thread.sleep(1000);

        //Locating process button and clicking to finish the order
        WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));

        processButton.click();

        Thread.sleep(1000);

        //Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.tagName("strong"));
       // WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        //we can also use xpath to locate success message

        Assert.assertTrue(successMessage.isDisplayed());

        String actualSuccessMessage = successMessage.getText();

        String expectedSuccessMessage = "New order has been successfully added.";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
