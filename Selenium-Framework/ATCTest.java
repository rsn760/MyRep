import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestJson extends Base implements ATCRepository {

  @DataProvider(name="signin Data")
    public Object[][] passData() throws IOException, ParseException, bsh.ParseException {
      
        return JSONreader.getdata("C:\\Users\\46879\\workspace\\JsonProject\\src\\main\\java\\Json3\\JsonData.json", "Signin Data",1 , 6);
    }  
    @Test(dataProvider = "signin Data")
    public void ATC_Test(String UserName, String password, String mobile, String tv, String hp, String lenovo) throws Exception
    {
         ExtentTest test= extent.createTest("launching the browser and adding all items to the cart");
        d.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
        // Sign in
        d.findElement(By.cssSelector(Nav_Link)).click();
        d.findElement(By.cssSelector(Email)).sendKeys(UserName);
        d.findElement(By.cssSelector(Continue)).click();
        d.findElement(By.cssSelector(Password)).sendKeys(password);

      WebElement rm = d.findElement(By.name(Remember_Me));
        rm.click();
      d.findElement(By.cssSelector(Submit)).click();

      // Mobile
        d.findElement(By.id(search_Bar)).sendKeys(mobile);
        d.findElement(By.xpath(search_Button)).click();
        d.findElement(By.partialLinkText(mob)).click();

      // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(d.getWindowHandles());

      //switch to new tab
        d.switchTo().window(newTb.get(1));
        d.findElement(By.id(Add_To_Cart_Button)).click();  
        d.findElement(By.xpath(c_P)).click();
        Thread.sleep(1000);

      // TV
        d.findElement(By.id(search_Bar)).clear();
        d.findElement(By.id(search_Bar)).sendKeys(tv);
        d.findElement(By.xpath(search_Button)).click();
        d.findElement(By.partialLinkText(Tv)).click();

      ArrayList<String> newTb1 = new ArrayList<String>(d.getWindowHandles());
        d.switchTo().window(newTb1.get(2));
        d.findElement(By.id(Add_To_Cart_Button)).click();
        d.findElement(By.xpath(c_P)).click();
        Thread.sleep(1000);

      // HP Laptop
        d.findElement(By.id(search_Bar)).clear();
        d.findElement(By.id(search_Bar)).sendKeys(hp);
        d.findElement(By.xpath(search_Button)).click();
        d.findElement(By.partialLinkText(HP_Lap)).click();

      ArrayList<String> newTb2 = new ArrayList<String>(d.getWindowHandles());
        d.switchTo().window(newTb2.get(3));

      Select Qnt = new Select(d.findElement(By.xpath(qnt)));
        Qnt.selectByIndex(1);
        d.findElement(By.id(Add_To_Cart_Button)).click();
        d.findElement(By.xpath(c_P)).click();
        Thread.sleep(1000);

      // Lenovo Laptop
        d.findElement(By.id(search_Bar)).clear();
        d.findElement(By.id(search_Bar)).sendKeys(lenovo);
        d.findElement(By.xpath(search_Button)).click();
        d.findElement(By.partialLinkText(Lenovo_Lap)).click();

      ArrayList<String> newTb3 = new ArrayList<String>(d.getWindowHandles());
        d.switchTo().window(newTb3.get(4));
        d.findElement(By.id(Add_To_Cart_Button)).click();
        d.findElement(By.xpath(c_P)).click();
        Thread.sleep(1000);

      // Cart
        d.findElement(By.xpath(cart)).click();
        d.findElement(By.xpath(HP_Remove)).click();

      // Total price
        String TotalPrice = d.findElement(By.xpath(Total_Price)).getText();
        System.out.println("Total price: "+TotalPrice);
        test.log(Status.PASS,"user adding items to the add to cart.  and displaying total price.");
        test.pass("verified all items");

  }
}