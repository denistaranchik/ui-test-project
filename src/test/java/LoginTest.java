import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseLoginTest{

    private final String loginErrorCredentials = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "The credentials provided are incorrect";
    private final String loginErrorCustomerNotFound = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    private final String emailInputError = "Please enter a valid email address.";

    HomePage homePage;
    LoginPage loginPage;
    BasePage basePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        basePage = new BasePage();
    }

     @Test
     public void successfulLoginTest () {

         homePage.clickLoginButton();
         loginPage.fillEmailInput(basePage.getValidEmail());
         loginPage.fillPasswordInput(basePage.getValidPassword());
         loginPage.clickLoginButton();

         String actualCustomerInfoAfterLogin = homePage.getCustomerInfoText();
           assertEquals(actualCustomerInfoAfterLogin, basePage.getValidEmail());
 }

    @Test
    public void invalidEmailLoginTest () {

        homePage.clickLoginButton();
        loginPage.fillEmailInput(basePage.getInvalidEmail());
        loginPage.fillPasswordInput(basePage.getInvalidPassword());
        loginPage.clickLoginButton();

        String loginEmailInputError = loginPage.getErrorEmailInput();
           assertEquals(loginEmailInputError, emailInputError);
    }

    @Test
    public void invalidPasswordLoginTest () {

        homePage.clickLoginButton();
        loginPage.fillEmailInput(basePage.getValidEmail());
        loginPage.fillPasswordInput(basePage.getInvalidPassword());
        loginPage.clickLoginButton();

        String loginPasswordInputError = loginPage.getLoginError();
        assertEquals(loginPasswordInputError, loginErrorCredentials);
    }

    @Test
    public void emptyInputsLoginTest () {

        homePage.clickLoginButton();
        loginPage.clickLoginButton();

        String loginEmptyInputError= loginPage.getLoginError();
        assertEquals(loginEmptyInputError, loginErrorCustomerNotFound);
    }
}
