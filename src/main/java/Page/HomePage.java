package Page;

import com.microsoft.playwright.Locator;

import static Utils.Waiter.waitUntilElementIsVisible;


public class HomePage extends BasePage {

    private final Locator registrationButton = BasePage.page.locator(".ico-register");
    private final Locator loginButton = BasePage.page.locator(".ico-login");
    private final Locator logoutButton = BasePage.page.locator(".ico-logout");
    private final Locator searchInput = BasePage.page.locator("#small-searchterms");
    private final Locator searchButton = BasePage.page.locator(".button-1.search-box-button");
    public final Locator customerInfo = BasePage.page.locator("//div[@class='header-links']//a[contains(@class, 'account')]"
    );
    public final Locator searchResultTitle = BasePage.page.locator("//h2[@class='product-title']");


    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return new RegistrationPage();
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    public HomePage clickLogoutButton() {
        logoutButton.click();
        return this;
    }

    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public HomePage fillSearchInput(String query) {
        fillInput(searchInput, query);
        return this;
    }

    public String getCustomerInfoText() {
        waitUntilElementIsVisible(customerInfo);
        return customerInfo.innerText();
    }

    public String checkRegistrationButtonPresence() {
        return registrationButton.innerText();
    }

    public String checkLogOutButtonPresence() {
        waitUntilElementIsVisible(customerInfo);
        return logoutButton.innerText();
    }

    public String checkLogInButtonPresence() {
        return loginButton.innerText();
    }

    public String searchResultTitle() {
        return searchResultTitle.innerText();
    }

}


