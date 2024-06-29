package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Ui_HomePage {

    public Ui_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // we have other alternatives like xPath, class linkedText and more, but if there is id, you have to use it first,
    // cause the priority is (id).

    @FindBy (id = "userName")
    public WebElement username;

    @FindBy (id = "userEmail")
    public WebElement email;


    @FindBy (id = "currentAddress")
    public WebElement currentAddress;

    @FindBy (id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy (id = "submit")
    public WebElement submitButton;

    @FindBy (xpath = "//div[@class='border col-md-12 col-sm-12']")
    public WebElement assertion;





}
