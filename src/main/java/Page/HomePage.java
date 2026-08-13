package Page;

import com.microsoft.playwright.Locator;

public class HomePage{

    private final Locator registrationButton = BasePage.page.locator(".ico-register");
    private final Locator loginButton = BasePage.page.locator(".ico-login");
    private final Locator logoutButton = BasePage.page.locator(".ico-logout");
    private final Locator searchInput = BasePage.page.locator("#small-searchterms");
    private final Locator searchButton = BasePage.page.locator(".button-1.search-box-button");
    private final Locator customerInfo = BasePage.page.locator("(//a[contains(@class, 'account')])[1]");
    private final Locator customerInfoAbsence = BasePage.page.locator(".ico-register");
    private final Locator sortedByFieldSearchValidResult = BasePage.page.locator("#products-orderby");

    // Click methods

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

    public void clickSearchInput() {
        searchInput.click();
    }

    public HomePage clickSearchButton() {
        searchButton.click();
        return this;
    }

    // Fill methods

    public HomePage fillSearchInput(String input) {
        searchInput.fill(input);
        return this;
    }

    // Assertions

    public String getCustomerInfoText() {
        return customerInfo.innerText();
    }

    public String checkCustomerInfoTextAbsence() {
        return customerInfoAbsence.innerText();
    }

    public String checkLogOutButtonPresence() {
        return logoutButton.innerText();
    }

    public String checkLogInButtonPresence() {
        return loginButton.innerText();
    }

    public boolean isSortBySelectVisible() {
        return sortedByFieldSearchValidResult.isVisible();
    }

    }


