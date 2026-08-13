package Page;

import com.microsoft.playwright.Locator;

public class LoginPage {

    private final Locator emailInput = BasePage.page.locator("#Email");
    private final Locator loginButton = BasePage.page.locator(".login-button");
    private final Locator passwordInput = BasePage.page.locator("#Password");
    private final Locator failureLoginError = BasePage.page.locator(".validation-summary-errors");
    private final Locator errorEmailInput = BasePage.page.locator(".field-validation-error");


    // Fill methods

    public LoginPage fillEmailInput(String value) {
         emailInput.fill(value);
         return this;
    }

    public LoginPage fillPasswordInput(String value) {
        passwordInput.fill(value);
        return this;
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage();
    }

    // Assertions

    public String getLoginError() {
        return failureLoginError.innerText();
    }

    public String getErrorEmailInput() {
        return errorEmailInput.innerText();
    }

}
