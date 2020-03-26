package practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Example2CartTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
    }

    @Test
    public void particularItemsShopping() {
        String[] itemsAccSpec= {"Cucumber","Brocolli","Beetroot"};

        List<WebElement> itemsFound = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < itemsFound.size(); i++) {
            String text = itemsFound.get(i).getText();
            if(itemsFound.contains("Brocolli")){
                System.out.println("Test passed");
            }



            //it appears in that mode: !!! We want just Banana without "-"
                // Banana - 1 Kg
                //Grapes - 1 Kg







        }


    }


}
