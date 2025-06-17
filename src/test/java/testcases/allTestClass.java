package testcases;
import PageObject.*;
import Utilities.baseClass;
import com.github.javafaker.Faker;
import org.testng.annotations.*;
import Utilities.DataProviders;
import java.io.IOException;




public class allTestClass extends baseClass {



    Faker faker;
    String fakeEmail;


    @Test(enabled = false)
    public void createUser() throws InterruptedException, IOException {

        SS("createUser");

       faker = new Faker();
       fakeEmail = faker.internet().emailAddress();;
       String fakeFirstName= faker.name().firstName();
       String fakeLastName= faker.name().lastName();



        indexpage ind = new indexpage(driver);
        ind.clickSignin();
        logger.info("signin clicked");

        createLogin cl = new createLogin(driver);
        cl.enterUsername(fakeEmail);
        cl.clickSubmitButton();
        logger.info("Submit button clicked and user name is : "+fakeEmail);

        accountCreation acc = new accountCreation(driver);
        acc.registerUser(fakeFirstName,fakeLastName,"SingleKing70$") ;
        logger.info("New  User Created");

    }

    @Test(enabled = false,dataProvider = "exceldata", dataProviderClass = DataProviders.class)
    public void login(String email, String Password) throws IOException {

        SS("login");

        indexpage ind = new indexpage(driver);
        ind.clickSignin();
        logger.info("signin clicked");



        loginToApp login = new loginToApp(driver);

        login.loginUser(email, Password);
        logger.info("User Login Successfull");

    }


@Test()
public void OrderDress() throws IOException {

    SS("login");

    //Signin click
    indexpage ind = new indexpage(driver);
    ind.clickSignin();
    logger.info("signin clicked");

    //login to App
    loginToApp login = new loginToApp(driver);
    String emailid = "biji@gmail.com";
    String Password = "SingleKing70$ ";
    login.loginUser(emailid,Password);
    logger.info("User Login Successfull");

    //order product
    tshirts ts = new tshirts(driver);
    ts.searchproduct("printed summer dress");
    logger.info("selected printed summer dress");
    ts.amountSummarypage();
    logger.info("ammount summary page executed");
//    ts.yourAdress();
//    logger.info("yourAdress page executed");
    ts.BillingAdress();
    logger.info("BillingAdress page executed");
    ts.ShippingAdress();
    logger.info("ShippingAdress page executed");
    ts.payment();
    logger.info("payment page executed");

    //signout
    logoutFromApp logouts = new logoutFromApp(driver);
    logouts.signout();
    logger.info("Signout successfull");


}
}
