import Constant.Errors;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constant.Buttons.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static config.ConfigReader.*;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseLoginTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

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
                .fillEmailInput(getValidEmail())
                .fillPasswordInput(getValidPassword())
                .clickConfirmLoginButton();

        assertEquals(homePage.getCustomerInfoText(), (getValidEmail()));
        assertEquals(homePage.checkLogOutButtonPresence(), LOGOUT.getButtonName());

    }

    @Test(dataProvider = "LoginData")
    public void invalidCredentialsLoginTest(String email, String password, String errorMessage) {

        logger.info("Attempt log into profile with email={}", email);

        homePage.clickLoginButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickConfirmLoginButton();

        logger.info("Login submitted, verifying error message");

        assertEquals(loginPage.getLoginError(), errorMessage, "Expect: 'Login was unsuccessful. " +
                "Please correct the errors and try again.'");
        assertEquals(homePage.checkLogInButtonPresence(), LOGIN.getButtonName(), "Expect " +
                "login button is still visible after failed login with empty inputs");

        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName(), "Expect " +
                "register button is still visible after failed login with empty inputs");

        logger.info("invalidCredentialsLoginTest passed for email={}", email);
    }

    @Test
    public void invalidEmailLoginTest() {
        homePage.clickLoginButton()
                .fillEmailInput(getInvalidEmail())
                .clickConfirmLoginButton();

        assertEquals(loginPage.getErrorEmailInput(), Errors.EMAIL_INPUT_ERROR, "Expect 'please" +
                " enter a valid email address' error message");
        assertEquals(homePage.checkLogInButtonPresence(), LOGIN.getButtonName(), "Expect " +
                "login button is still visible after failed login with empty inputs");

        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName(), "Expect " +
                "register button is still visible after failed login with empty inputs");
    }

    @Test
    public void emptyInputsLoginTest() {

        homePage.clickLoginButton()
                .clickConfirmLoginButton();

        assertEquals(loginPage.getNoCustomerFoundError(), Errors.LOGIN_ERROR_CUSTOMER_NOT_FOUND, "Expect 'customer" +
                " not found' error message");
        assertEquals(homePage.checkLogInButtonPresence(), LOGIN.getButtonName(), "Expect " +
                "login button is still visible after failed login with empty inputs");
    }
}
