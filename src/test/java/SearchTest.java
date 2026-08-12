import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseLoginTest{

    private final String validSearchInput = "Book";

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
    public void successfulSearchByUnauthorizedUserTest () {
        homePage.fillSearchInput(validSearchInput);
        homePage.clickSearchButton();

        assertTrue(homePage.isSortBySelectVisible());
    }

    @Test
    public void successfulSearchByAuthorizedUserTest () {
        homePage.clickLoginButton();
        loginPage.fillEmailInput(basePage.getValidEmail());
        loginPage.fillPasswordInput(basePage.getValidPassword());
        loginPage.clickLoginButton();
        homePage.fillSearchInput(validSearchInput);
        homePage.clickSearchButton();

        assertTrue(homePage.isSortBySelectVisible());
    }
}
