import Page.HomePage;
import Page.LoginPage;
import facade.LoginFacade;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constant.Buttons.REGISTER;
import static org.testng.Assert.assertEquals;


public class LogoutTest extends BaseLoginTest {

        HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }
    @Test
    public void successfulLogoutTest() {

                 new LoginFacade()
                .login()
                .clickLogoutButton();

        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName(), "Register button" +
                " should be visible again after successful logout");
    }
}
