import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
    protected static ExtentReports extent = null;
    private static ExtentSparkReporter spark = null;
    static WebDriver d;
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Open Amazon and Update cart with Price");
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.amazon.in/");
      
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(spark);
        
    }
    @AfterMethod
    public void afterMethod()
    {
        extent.flush();
        d.quit();
    }
}
