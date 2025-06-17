package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wishlist {

    WebDriver driver;

    public void wishlist(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input#search_query_top")
    WebElement searchBar;


    @FindBy(xpath="//button[@name='submit_search']")
    WebElement searchButtonn;

    public void searchdress(String dressname){
        searchBar.sendKeys(dressname);
        searchButtonn.click();
    }

}
