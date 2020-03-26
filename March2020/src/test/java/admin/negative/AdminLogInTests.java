package admin.negative;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLogInPage;
import utils.Browser;

public class AdminLogInTests {
    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void unsuccesfulAdminLogin() {
        AdminLogInPage.goTo();
        AdminLogInPage.login("Joro", "parola123!");
        AdminLogInPage.verifyErrorValidationMessage("No match for Username and/or Password.",
                "The expected validation error message is INCORRECT!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }


}

