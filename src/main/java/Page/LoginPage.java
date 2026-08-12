package Page;

import com.microsoft.playwright.Locator;

public class LoginPage {

    private final Locator emailInput = BasePage.page.locator("#Email");
    private final Locator loginButton = BasePage.page.locator(".login-button");
    private final Locator passwordInput = BasePage.page.locator("#Password");
    private final Locator failureLoginError = BasePage.page.locator(".validation-summary-errors");
    private final Locator errorEmailInput = BasePage.page.locator(".field-validation-error");

    // Click methods

    public void clickEmailInput() {
        emailInput.click();
    }

    public void passwordInput() {
        passwordInput.click();
    }

    // Fill methods

    public void fillEmailInput(String value) {
        emailInput.fill(value);
    }

    public void fillPasswordInput(String value) {
        passwordInput.fill(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    // Assertions

    public String getLoginError() {
        return failureLoginError.innerText();
    }

    public String getErrorEmailInput() {
        return errorEmailInput.innerText();
    }

}
