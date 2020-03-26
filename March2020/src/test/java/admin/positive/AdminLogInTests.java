package admin.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLogInPage;
import utils.Browser;
import utils.CommonVerifications;

public class AdminLogInTests {

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void adminLoginTest() {
        AdminLogInPage.goTo();
        AdminLogInPage.login("admin", "parola123!");

        CommonVerifications.verifyTitle("Dashboard", "The login was unsuccessful!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
