package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class extentReports implements ITestListener {
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;

    public void onStart(ITestContext context) {

        ReadConfig readConfig = new ReadConfig();

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/reports.html");
        sparkReporter.config().setDocumentTitle("Vdoc");
        sparkReporter.config().setReportName("Login");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Username", "Vijay");
        extent.setSystemInfo("UserID", "2");
        extent.setSystemInfo("browserName",readConfig.browser() );

        }


        public void onTestSuccess(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.PASS,"Passed test is : "+result.getName());
        }

        public void onTestFailure(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.FAIL,"Failed test is : "+result.getName());

        String filepath = System.getProperty("user.dir")+"/ScreenShots/"+result.getName()+".png";
        File SSFile = new File(filepath);
        if (SSFile.exists())
        {
            test.fail("Failed test is:"+test.addScreenCaptureFromPath(filepath));
        }


        }

        public void onTestSkipped(ITestResult result){
        test= extent.createTest(result.getName());
        test.log(Status.SKIP,"Failed test is : "+result.getName());
        }

        public void onFinish(ITestContext context){
        extent.flush();
        }


    }

