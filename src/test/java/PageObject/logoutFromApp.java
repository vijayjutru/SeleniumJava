package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutFromApp {
    WebDriver driver;

    public logoutFromApp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[title=\"Log me out\"]")
    WebElement signout;

    public void signout(){
        signout.click();
    }
}
