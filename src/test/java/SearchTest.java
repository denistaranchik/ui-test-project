import Page.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static config.ConfigReader.*;


public class SearchTest extends BaseLoginTest {

    private final String VALID_SEARCH_INPUT = "Book";

    HomePage homePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
    }

    @Test
    public void successfulSearchByUnauthorizedUserTest() {

        homePage.fillSearchInput(VALID_SEARCH_INPUT)
                .clickSearchButton();

        assertTrue(homePage.searchResultTitle().toLowerCase().contains("book"),
                "Product title does not contain: 'book'");
    }

    @Test
    public void successfulSearchByAuthorizedUserTest() {

        homePage.clickLoginButton()
                .fillEmailInput(getValidEmail())
                .fillPasswordInput(getValidPassword())
                .clickConfirmLoginButton()
                .fillSearchInput(VALID_SEARCH_INPUT)
                .clickSearchButton();

        assertTrue(homePage.searchResultTitle().toLowerCase().contains("book"),
                "Product title does not contain: 'book'");
    }
}
