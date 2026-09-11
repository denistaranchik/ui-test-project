import Page.HomePage;
import facade.LoginFacade;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class SearchTest extends BaseLoginTest {

    private final String VALID_SEARCH_INPUT = "Book";

    HomePage homePage;
    LoginFacade loginFacade;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        loginFacade = new LoginFacade();
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

        HomePage homePage = loginFacade.login()
                .fillSearchInput(VALID_SEARCH_INPUT)
                .clickSearchButton();

        assertTrue(homePage.searchResultTitle().toLowerCase().contains("book"),
                "Product title should contain: 'book' but does not");
    }
}
