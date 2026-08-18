import Page.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constant.Buttons.REGISTER;
import static org.testng.Assert.assertEquals;
import static config.ConfigReader.*;


public class LogoutTest extends BaseLoginTest {

    HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }

    @Test
    public void successfulLogoutTest() {

        homePage.clickLoginButton()
                .fillEmailInput(getValidEmail())
                .fillPasswordInput(getValidPassword())
                .clickConfirmLoginButton()
                .clickLogoutButton();

        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName(), "Register button" +
                " should be visible again after successful logout");
    }
}
