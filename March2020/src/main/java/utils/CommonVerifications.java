package utils;

import org.testng.Assert;

public class CommonVerifications {

    public static void verifyTitle(String expected, String errorMessage) {

        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, expected, errorMessage);
    }
}
