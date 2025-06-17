package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginToApp {
    WebDriver driver;

    public loginToApp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement loginid;

    @FindBy(id = "passwd")
    WebElement loginpassword;

    @FindBy(id="SubmitLogin")
    WebElement submitbtn;

    @FindBy(css = "[title='View my customer account']")
    WebElement Title;

    public void loginUser(String emailid, String password){
        loginid.sendKeys(emailid);
        loginpassword.sendKeys(password);
        submitbtn.click();
        Title.isDisplayed();


    }
}
