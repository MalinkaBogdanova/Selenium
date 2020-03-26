package practise3;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

public class FoodPanda {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testExplicitWaitClassDemo() {
        driver.get("https://www.foodpanda.bg/");
        driver.findElement(cssSelector("input#delivery-information-postal-index"))
                .sendKeys("Славейков 28");
        //ж.к. Славейков 28, 8005 ж.к. Петко Р. Славейков, Бургас, България
        driver.findElement(cssSelector("input#delivery-information-postal-index")).sendKeys(Keys.ENTER);
        driver.findElement(cssSelector("div.two-buttons button.js-restaurants-search-button.gtm-homepage-delivery-button.restaurants-search-form__button--flexible.js-ripple")).click();
        //div.two-buttons button.js-restaurants-search-button.gtm-homepage-delivery-button.restaurants-search-form__button--flexible.js-ripple")).click();
        Wait<WebDriver> webDriverWait = new WebDriverWait(driver, 30);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cssSelector("span.name.fn")));

        List<WebElement> allRestorantList = driver.findElements(cssSelector("span.name.fn"));

        System.out.println(allRestorantList.size());

        for (int i = 0; i <allRestorantList.size() ; i++) {
            String restaurants = allRestorantList.get(i).getText();
            if(restaurants.contains("Pizza")){
                System.out.println(restaurants);
                assertTrue(restaurants.contains("Pizza"));
            }

        }

//        for (WebElement curRestaurantName : allRestorantList) {
//            //left the print below only for log purposes in the console log :)
//            System.out.println(curRestaurantName.getText());
//            if (curRestaurantName.getText().contains("restaurant depo")) {
//                //returning out of a void method, which will stop the test execution and mark the test as passed.
//                return;
//            }
//            Assert.fail("Fail the test");
//        }

    }
       @Test
        public void testExplicitWaitByTitle(){
        driver.get("https://search.yahoo.com/");
        driver.findElement(By.cssSelector("button.btn.primary")).click();

        WebElement searchSpace = driver.findElement(By.cssSelector("input#yschsp"));
        searchSpace.sendKeys("sony");
        searchSpace.submit();

        WebDriverWait wd = new WebDriverWait(driver,30);

        wd.until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                public Boolean apply(@NullableDecl WebDriver driver) {
                    return driver.getTitle().toLowerCase().startsWith("sony");
                }
            });
        assertTrue(driver.getTitle().toLowerCase().startsWith("sony"));

            }
           }



