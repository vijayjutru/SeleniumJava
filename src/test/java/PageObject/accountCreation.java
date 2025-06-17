package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class accountCreation {
    WebDriver driver;

    public accountCreation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement TitleRadiobtn;

    @FindBy(id = "customer_firstname")
    WebElement FirstName;

    @FindBy(id = "customer_lastname")
    WebElement Lastname;

    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "passwd")
    WebElement Password;

    @FindBy(id = "days")
    WebElement Days;

    @FindBy(id = "months")
    WebElement Months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement NewsletterRadiobtn;

    @FindBy(id = "submitAccount")
    WebElement Registerbtn;

    @FindBy(css = "a[class='account']")
    WebElement userTitle;

    public void registerUser(String firstname,String lastname, String password){
        TitleRadiobtn.click();
        FirstName.sendKeys(firstname);
        Lastname.sendKeys(lastname);
        Password.sendKeys(password);

        Select day = new Select(Days);
        day.selectByValue("2");

        Select  mon= new Select(Months);
        mon.selectByValue("10");

        Select yea = new Select(years);
        yea.selectByValue("1996");

        NewsletterRadiobtn.click();
        Registerbtn.click();

        userTitle.isDisplayed();
        String text =userTitle.getText();


        Assert.assertEquals(text ,firstname+" "+lastname );


    }



}
