package test.day07_WebTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC30_CybertekRegistrationForm {

    /*
    TC#30: Cybertek registration form confirmation
Note: Use JavaFaker when possible.
1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You've successfully completed registration!” is
displayed.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void registrationForm_confirmation() throws InterruptedException{

        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstName.sendKeys(faker.name().firstName());

        Thread.sleep(1000);

        //4. Enter last name
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));

        lastName.sendKeys(faker.name().lastName());

        Thread.sleep(1000);

        //5. Enter username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));

       // username.sendKeys(faker.name().firstName());
        username.sendKeys("funnyName12");

        Thread.sleep(1000);

        //6. Enter email address
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));

        email.sendKeys(faker.internet().emailAddress());

        Thread.sleep(1000);

        //7. Enter password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        password.sendKeys(faker.internet().password());

        Thread.sleep(1000);

        //8. Enter phone number
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));

        //phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
        phoneNumber.sendKeys("234-233-2344");

        Thread.sleep(1000);

        //9. Select a gender from radio buttons
        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));

        gender.click();

        Thread.sleep(1000);

        //10.Enter date of birth
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));

        dateOfBirth.sendKeys("11/10/1998");

        Thread.sleep(1000);

        //11. Select Department/Office
        WebElement department = driver.findElement(By.xpath("//select[@name='department']"));

        //because department is select dropdown, we have to create instance of Select class
        Select selectDepartment = new Select(department);

        selectDepartment.selectByValue("AO");

        Thread.sleep(1000);

        //12. Select Job Title

        WebElement jobTitle = driver.findElement(By.xpath("//select[@name='job_title']"));

        //because job is select dropdown, we have to create instance of Select class
        Select selectJobTitle = new Select(jobTitle);

        selectJobTitle.selectByVisibleText("SDET");

        Thread.sleep(1000);

        //13. Select programming language from checkboxes
        WebElement programmingLanguage = driver.findElement(By.xpath("//input[@value='java']"));

        programmingLanguage.click();

        Thread.sleep(1000);

        //14. Click to sign up button
        WebElement signInButton = dateOfBirth.findElement(By.xpath("//button[@type='submit']"));

        signInButton.click();

        //Verify success message “You’ve successfully completed registration.” is
        //displayed

        WebElement successMessage = driver.findElement(By.tagName("p"));

        Assert.assertTrue(successMessage.isDisplayed());

        String actualSuccessMessage = successMessage.getText();

        String expectedSuccessMessage = "You've successfully completed registration!";

        System.out.println("actualSuccessMessage = " + actualSuccessMessage);

        Assert.assertTrue(actualSuccessMessage.equals(expectedSuccessMessage));

    }

    @AfterMethod
    public void teardown(){

        driver.close();

    }

}
