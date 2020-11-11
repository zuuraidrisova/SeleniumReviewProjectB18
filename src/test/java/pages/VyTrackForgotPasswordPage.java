package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackForgotPasswordPage {

    public VyTrackForgotPasswordPage(){

        //creating connection between the driver and object of current class
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //locating input box
    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement inputBox;

    //locating request button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;

    //locating error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;



}
