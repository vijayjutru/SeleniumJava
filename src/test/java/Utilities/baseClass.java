package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class baseClass {

    public static WebDriver driver;
    public static Logger logger;
    String Site_Url;

    @BeforeMethod
    public void setUp() throws IOException {

        ReadConfig reConfig = new ReadConfig();
        Site_Url =  reConfig.baseURL();
        String Browser_Type = reConfig.browser();
        switch(Browser_Type.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser type is defined");
                driver =null;
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger = LogManager.getLogger("Myfile");

        driver.get(Site_Url);
        logger.info("URL opened");

    }

    public void SS(String testcase) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File Sf =ts.getScreenshotAs(OutputType.FILE);
        File Tar = new File(System.getProperty("user.dir")+"/ScreenShots/"+testcase+".png");
        FileUtils.copyFile(Sf,Tar);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown Executed");
    }




}
