import Constant.Errors;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constant.Buttons.*;
import static Constant.Errors.*;
import static config.ConfigReader.*;
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
                .fillEmailInput(getValidEmail())
                .fillPasswordInput(getValidPassword())
                .clickConfirmLoginButton();

        assertEquals(homePage.getCustomerInfoText(),(getValidEmail()));
        assertEquals(homePage.checkLogOutButtonPresence(), LOGOUT.getButtonName());

    }

    @Test(dataProvider = "LoginData")
    public void invalidCredentialsLoginTest(String email, String password, String errorMessage) {

        homePage.clickLoginButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickConfirmLoginButton();

        // assertEquals(loginPage.getErrorEmailInput(), errorMessage);
        // assertEquals(loginPage.getLoginError(), errorMessage);
        assertEquals(homePage.checkLogInButtonPresence(), LOGIN.getButtonName(), "Message");
        assertEquals(homePage.checkRegistrationButtonPresence(), REGISTER.getButtonName());

    }

    @Test
    public void emptyInputsLoginTest() {

        homePage.clickLoginButton()
                .clickConfirmLoginButton();

        assertEquals(loginPage.getLoginError(), Errors.LOGIN_ERROR_CUSTOMER_NOT_FOUND);
        assertEquals(homePage.checkLogInButtonPresence(), LOGIN.getButtonName());
    }
}
