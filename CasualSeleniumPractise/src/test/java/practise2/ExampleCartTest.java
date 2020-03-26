package practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExampleCartTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //  Going to the pragmatic shop page
        driver.get("http://shop.pragmatic.bg/");
    }

    @Test
    public void testCartExample() {
        //assert we are on the right page
        assertEquals(driver.getTitle(),"Pragmatic Test Store");

        //  Write some random text in the search bar in http://shop.pragmatic.bg/
        driver.findElement(By.cssSelector("input.input-lg")).sendKeys("etc.");
        //  Click on the search button
        driver.findElement(By.cssSelector("i.fa-search")).click();
        String expectedMsm="Your shopping cart is empty!";
        //  Asserting the result of our search above - in this case it won't find anything based on the input "Blablablablabal"
        System.out.println(driver.findElement
                (By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")).getText());
        assertEquals(expectedMsm, "Your shopping cart is empty!" );
        //  Changing the search to something meaningful - in this case Sony!
        driver.findElement(By.cssSelector("input.input-lg")).clear();
        driver.findElement(By.cssSelector("input.input-lg")).sendKeys("sony");
        driver.findElement(By.cssSelector("i.fa-search")).click();
        //  Choosing the category Phones and PDAs from the dropDown menu next to the search bar!
        Select select = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
        select.selectByVisibleText("Mobile Phones");
        //  Checking the subcategory checkbox
       driver.findElement(By.cssSelector("div label.checkbox-inline")).click();
       assertTrue(driver.findElement(By.cssSelector("div label.checkbox-inline")).isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
