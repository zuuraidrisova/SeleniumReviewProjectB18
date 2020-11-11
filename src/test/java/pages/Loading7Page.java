package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Loading7Page {

    public Loading7Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //    @FindBy(xpath = "//strong") also works
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible fade show']/strong")
    public WebElement doneMessage;

    @FindBy(xpath = "//img")
    public WebElement spongeBobImage;

}
