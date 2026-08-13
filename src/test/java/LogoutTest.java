import Constant.Buttons;
import Constant.Credentials;
import Page.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseLoginTest{

    HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }

    @Test
    public void successfulLogoutTest () {

        homePage.clickLoginButton()
            .fillEmailInput(Credentials.VALID_EMAIL.getCredentials())
            .fillPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
            .clickLoginButton()
            .clickLogoutButton();

        assertEquals(homePage.checkCustomerInfoTextAbsence(), Buttons.REGISTER.getButtonName());
    }
}
