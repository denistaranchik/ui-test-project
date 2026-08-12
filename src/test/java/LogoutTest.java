import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseLoginTest{

    private final String registerButtonText = "Register";

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
    public void successfulLogoutTest () {

        homePage.clickLoginButton();
        loginPage.fillEmailInput(basePage.getValidEmail());
        loginPage.fillPasswordInput(basePage.getValidPassword());
        loginPage.clickLoginButton();
        homePage.clickLogoutButton();

        String customerInfoTextAbsenceAfterLogout = homePage.checkCustomerInfoTextAbsence();
        assertEquals(customerInfoTextAbsenceAfterLogout, registerButtonText);
    }
}
