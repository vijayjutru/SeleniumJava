package PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createLogin {


    WebDriver driver ;

    public createLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "email_create")
    WebElement createEmail;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    public void enterUsername(String Username){
        createEmail.sendKeys(Username);


    }
    public void clickSubmitButton(){

        createAnAccountButton.click();

    }




}
