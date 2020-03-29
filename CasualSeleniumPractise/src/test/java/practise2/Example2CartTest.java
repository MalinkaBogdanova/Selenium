package practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        //declare as array
      String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
             // String itemsNeeded = "Cucumber";
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");//split the name where the "- " is
            String trimmedName = name[0].trim();// remove the empty space from the first part
//            if(name.contains("Cucumber")){
//               //go and click on it to add to cart
//                driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]")).get(i).click();
                     //break;
            //However I want multiple items to add
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            int j=0;
            if(itemsNeededList.contains(trimmedName)){
                j++;
                driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]")).get(i).click();
                if(j==3){
                    break;
                }

            }


        }
        assertTrue(driver.findElement(By.cssSelector("div.cart-info")).getText().contains("3"));
        }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}




