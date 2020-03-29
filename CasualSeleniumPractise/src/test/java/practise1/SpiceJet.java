package practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SpiceJet {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.spicejet.com/");
    }

    @Test
    public void testSpiceJetDynamicDropdown() {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // //a[contains(text(),'Belagavi (IXG)')]
        driver.findElement(By.xpath("//a[contains(text(),'Belagavi (IXG)')]")).click();
        assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Belagavi (IXG)')]")).getText(),"Belagavi (IXG)");
        driver.findElement(By.xpath("(// a[contains(text(),'Chennai (MAA)')])[2]")).click();
        //(// a[contains(text(),'Chennai (MAA)')])[2] - go and hit the second option
        assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Chennai (MAA)')]")).getText(),"Chennai (MAA)");
        //calendar-selecting current date
        driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date1")).click();
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

        driver.findElement(By.cssSelector("#divpaxinfo")).click();

        //selecting 2 adults and 2 children
        Select adult=new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Adult")));
        adult.selectByValue("2");
        assertEquals(adult.getFirstSelectedOption().getText(),"2");

        Select children=new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Child")));
        children.selectByValue("2");
        assertEquals(children.getFirstSelectedOption().getText(),"2");

        Select infant=new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Infant")));
        infant.selectByVisibleText("1");
        assertEquals(infant.getFirstSelectedOption().getText(),"1");

    }

    @Test
    public void testSelectToArray() {
        Select currency=new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency")));
        currency.selectByValue("INR");

        // assertEquals(infant.getFirstSelectedOption().getText(),"1");
        assertEquals(currency.getOptions().size(), 4);
        assertFalse(currency.isMultiple());
        //the expected values
        ArrayList<String> expectedValues= new ArrayList<String>();
        expectedValues.add("Select");
        expectedValues.add("INR");
        expectedValues.add("AED");
        expectedValues.add("USD");
       // System.out.println(expectedValues);
        ArrayList<String> actualValues= new ArrayList<String>();

        List<WebElement> allOptions = currency.getOptions();

//        for (WebElement option:allOptions) {
//            actualValues.add(option.getText());
//        }
        for (int i = 0; i < allOptions.size(); i++) {
            actualValues.add(allOptions.get(i).getText());
        }

      assertEquals(actualValues.toArray(),expectedValues.toArray());
    }

    @Test
    public void radioButtonTest() {

        if (!driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0")).isSelected()) {
            driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0")).click();
        }
        assertTrue(driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0")).isSelected());

        driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
        assertTrue(driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).isSelected());


        driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_2")).click();
        assertTrue(driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_2")).isSelected());

        ArrayList<String> arrayListExpected =new ArrayList<String>();
        arrayListExpected.add("One Way");
        arrayListExpected.add("Round Trip");
        arrayListExpected.add("Multicity");

        List<WebElement> radioButtons = driver
                .findElements(By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']//tbody//tr//td"));

        ArrayList<String> arrayListActual = new ArrayList<String>();

        System.out.println(radioButtons.size());
        for (int i = 0; i < radioButtons.size(); i++) {
            arrayListActual.add(radioButtons.get(i).getText());
        }
        assertEquals(arrayListActual.toArray(),arrayListExpected.toArray());
        }

    @Test
    public void checkBoxesTest() {
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkboxes.size());
        assertTrue(checkboxes.size()==6);
    }

//    @Test
//    public void testCalendarDependency() {
//        //ctl00_mainContent_rbtnl_Trip_1 //
//        // .ui-state-default.ui-state-active //return date
//        //.ui-state-default.ui-state-highlight.ui-state-active//depart date
//        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();//round trip button should be enabled
//
//        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
//        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
//
//        {
//
//            System.out.println("its disabled");
//
//            Assert.assertTrue(true);
//
//        }
//
//        else
//
//        {Assert.assertTrue(false);
//
//        }
//    }
    //


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
