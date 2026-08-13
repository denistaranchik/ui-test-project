import Constant.Credentials;
import Page.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseLoginTest{

    private final String validSearchInput = "Book";

    HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }

    @Test
    public void successfulSearchByUnauthorizedUserTest () {

        homePage.fillSearchInput(validSearchInput)
                .clickSearchButton();

        assertTrue(homePage.isSortBySelectVisible());
    }

    @Test
    public void successfulSearchByAuthorizedUserTest () {

        homePage.clickLoginButton()
                .fillEmailInput(Credentials.VALID_EMAIL.getCredentials())
                .fillPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .clickLoginButton()
                .fillSearchInput(validSearchInput)
                .clickSearchButton();

        assertTrue(homePage.isSortBySelectVisible());
    }
}
