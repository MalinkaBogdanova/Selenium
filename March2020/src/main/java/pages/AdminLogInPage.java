package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminLogInPage {
    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOC_ERROR_VALIDATION_MESSAGE = By.cssSelector(".alert.alert-danger.alert-dismissible");

    /**
     * Method which takes you to the admin login page!
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    /**
     * Method that logins a user by username and password.
     */
    public static void login(String username, String password) {
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_LOGIN_BUTTON).click();
    }


    public static void verifyErrorValidationMessage(String expectedMessage, String messageInCaseOfIncorrectValidationMessage) {
        String actualErrorValidationMessage = Browser.driver.findElement(LOC_ERROR_VALIDATION_MESSAGE).getText();
        Assert.assertTrue(actualErrorValidationMessage.contains(expectedMessage), messageInCaseOfIncorrectValidationMessage);
    }
}
