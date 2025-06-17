
package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class tshirts {

    WebDriver driver;


    public tshirts(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css="input#search_query_top")
    WebElement searchBar;


    @FindBy(xpath="//button[@name='submit_search']")
    WebElement searchButtonn;

    @FindBy(xpath="//h5[@itemprop='name']//a[@title='Faded Short Sleeve T-shirts']")
    WebElement tshirtText;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[1]")
    WebElement mouse;

    @FindBy(xpath="//*[text()='More']")
    WebElement more;

    @FindBy(css="[name='group_1']")
    WebElement size;

    @FindBy(className="icon-plus")
    WebElement plus;

    @FindBy(id="add_to_cart")
    WebElement addtoCart;

    @FindBy(css= "[alt='Printed Summer Dress']")
    WebElement printeddress;

    @FindBy(xpath = "(//*[@title='Proceed to checkout'])[1]")
    WebElement ProccedToCheckout;

    @FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
    WebElement ProccedToCheckout2;


    //Address details page
    @FindBy(id="firstname")
    WebElement fname;

    @FindBy(id="lastname")
    WebElement lname;

    @FindBy(id="company")
    WebElement company;

    @FindBy(id="address1")
    WebElement address1;

    @FindBy(id="address2")
    WebElement address2;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="id_state")
    WebElement state;

    @FindBy(id="postcode")
    WebElement postcode;

    @FindBy(id="id_country")
    WebElement country;

    @FindBy(id="phone")
    WebElement phone;

    @FindBy(id="phone_mobile")
    WebElement mobile;

    @FindBy(id="other")
    WebElement AdditionalInformation;

    @FindBy(id="alias")
    WebElement alias;

    @FindBy(id="submitAddress")
    WebElement savebtn;

    @FindBy(css="[name=\"processAddress\"]")
    WebElement addresspageProceed;



    //Shipping page
    @FindBy(id="cgv")
    WebElement termsConditions;

    @FindBy(css="[name=\"processCarrier\"]")
    WebElement shippingPageProceed;


    //Payment page

    @FindBy(css = "[title='Pay by bank wire']")
    WebElement bankWire;

    @FindBy(css = "[class='button btn btn-default button-medium']")
    WebElement confirmMyOrder;


    @FindBy(css = "[class='alert alert-success']")
    WebElement SuccessMessage;



    public void searchproduct(String txt) {


        searchBar.sendKeys(txt);
        searchButtonn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", printeddress);

        Actions act = new Actions(driver);
        act.moveToElement(mouse).build().perform();
        more.click();

        js.executeScript("arguments[0].scrollIntoView(true);", size);

        Select select = new Select(size);
        select.selectByValue("2");
        select.selectByValue("1");
        select.selectByValue("2");
        plus.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_to_cart")));
        addtoCart.click();

        // main proceed
        ProccedToCheckout.click();

    }

    public void amountSummarypage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ProccedToCheckout2);
        ProccedToCheckout2.click();

    }

    public void yourAdress(){

        company.sendKeys("Cognizant");
        address1.sendKeys("Mindspace");
        address2.sendKeys("HitechCity");
        city.sendKeys("Hyderabad");
        Select us_state = new Select(state);
        us_state.selectByValue("14");
        postcode.sendKeys("47021");
        phone.sendKeys("+12101234567");
        mobile.sendKeys("+12101234567");
        AdditionalInformation.sendKeys("Nothing");
        alias.sendKeys("pichkoop");
        savebtn.click();


    }

    public void BillingAdress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addresspageProceed);
        addresspageProceed.click();

    }

    public void ShippingAdress() {

        termsConditions.click();
        shippingPageProceed.click();

    }


    public void payment(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",  bankWire);
        bankWire.click();
        confirmMyOrder.click();
        SuccessMessage.isDisplayed();

    }


}
