package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class indexpage {

    //create object for webdriver
    WebDriver driver;

    //creating constructor for initilizing page factory

    public indexpage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    //Saving web elements


    @FindBy(linkText = "Sign in")
    WebElement sign_in;

    @FindBy(id = "email_create")
    WebElement createEmail;

    //Action on WebElements by creating method
    public void clickSignin(){
    sign_in.click();
    }
}
