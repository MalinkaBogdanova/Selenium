package practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AirBuglaria {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.air.bg/bg");
    }

    @Test
    public void airBulgariaRandomTest() {
        //title assert
       assertEquals(driver.getTitle(),"Самолетни билети от България - Авиокомпания България Ер") ;
       //logo
       driver.findElement(By.cssSelector("div.logo a img")).click();
       assertTrue(driver.findElement(By.cssSelector("div.logo a img")).isDisplayed());
       //tel
        driver.findElement(By.cssSelector("i.tel")).click();
        assertTrue(driver.findElement(By.cssSelector("i.tel")).isDisplayed());


    }
}
