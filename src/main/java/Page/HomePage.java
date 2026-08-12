package Page;

import com.microsoft.playwright.Locator;

public class HomePage{

    private final Locator registrationButton = BasePage.page.locator(".ico-register");
    private final Locator loginButton = BasePage.page.locator(".ico-login");
    private final Locator logoutButton = BasePage.page.locator(".ico-logout");
    private final Locator searchInput = BasePage.page.locator("#small-searchterms");
    private final Locator searchButton = BasePage.page.locator(".button-1.search-box-button");
    private final Locator customerInfo = BasePage.page.locator(".account")
                             .filter(new Locator.FilterOptions().setHasText("@"));
    private final Locator customerInfoAbsence = BasePage.page.locator(".ico-register")
            .filter(new Locator.FilterOptions().setHasText("Register"));
    private final Locator sortedByFieldSearchValidResult = BasePage.page.locator("#products-orderby");

    // Click methods

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void clickLoginButton() {
           loginButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickSearchInput() {
        searchInput.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    // Fill methods

    public void fillSearchInput(String input) {
        searchInput.fill(input);
    }

    // Assertions

    public String getCustomerInfoText() {
        return customerInfo.innerText();
    }

    public String checkCustomerInfoTextAbsence() {
        return customerInfoAbsence.innerText();
    }

    public boolean isSortBySelectVisible() {
        return sortedByFieldSearchValidResult.isVisible();
    }

    }


