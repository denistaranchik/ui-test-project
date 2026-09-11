import Page.HomePage;
import facade.LoginFacade;
import org.testng.annotations.Test;

import static constant.Buttons.REGISTER;
import static org.testng.Assert.assertEquals;


public class LogoutTest extends BaseLoginTest {

    @Test
    public void successfulLogoutTest() {

        HomePage homePage = new LoginFacade()
                .login()
                .clickLogoutButton();

        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName(), "Register button" +
                " should be visible again after successful logout");
    }
}
