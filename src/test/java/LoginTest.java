import Constant.Buttons;
import Constant.Credentials;
import Constant.Errors;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseLoginTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void successfulLoginTest() {

        homePage.clickLoginButton()
                .fillEmailInput(Credentials.VALID_EMAIL.getCredentials())
                .fillPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .clickLoginButton();

        assertEquals(homePage.getCustomerInfoText(), Credentials.VALID_EMAIL.getCredentials());
        assertEquals(homePage.checkLogOutButtonPresence(), Buttons.LOGOUT.getButtonName());

    }

    @Test
    public void invalidEmailLoginTest() {

        homePage.clickLoginButton()
                .fillEmailInput(Credentials.INVALID_EMAIL.getCredentials())
                .fillPasswordInput(Credentials.INVALID_PASSWORD.getCredentials())
                .clickLoginButton();

        assertEquals(loginPage.getErrorEmailInput(), Errors.EMAIL_INPUT_ERROR);
        assertEquals(homePage.checkLogInButtonPresence(), Buttons.LOGIN.getButtonName());

    }

    @Test
    public void invalidPasswordLoginTest() {

        homePage.clickLoginButton()
                .fillEmailInput(Credentials.VALID_EMAIL.getCredentials())
                .fillPasswordInput(Credentials.INVALID_PASSWORD.getCredentials())
                .clickLoginButton();

        assertEquals(loginPage.getLoginError(), Errors.LOGIN_ERROR_CREDENTIALS);
        assertEquals(homePage.checkLogInButtonPresence(), Buttons.LOGIN.getButtonName());
    }

    @Test
    public void emptyInputsLoginTest() {

        homePage.clickLoginButton()
                .clickLoginButton();

        assertEquals(loginPage.getLoginError(), Errors.LOGIN_ERROR_CUSTOMER_NOT_FOUND);
        assertEquals(homePage.checkLogInButtonPresence(), Buttons.LOGIN.getButtonName());
    }
}
