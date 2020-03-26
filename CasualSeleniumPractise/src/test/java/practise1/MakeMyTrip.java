package practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MakeMyTrip {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
    }

    @Test
    public void makeMyTripTest() {
        //
        WebElement from = driver.findElement(By.xpath("//div[contains(@class,'react-autosuggest__container react-autosuggest__container--open')]"));
        from.clear();
        from.sendKeys("MUM");
        from.sendKeys(Keys.ENTER);

        //
        //driver.findElement(By.xpath("//span[contains(text(),'To')]")).click();
    }
}
