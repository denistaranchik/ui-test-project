package Page;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    private final Locator confirmLoginButton = BasePage.page.locator(".login-button");
    private final Locator failureLoginError = BasePage.page.locator(".validation-summary-errors");
    private final Locator errorEmailInput = BasePage.page.locator(".field-validation-error");


    public LoginPage fillEmailInput(String email) {
        fillInput(emailInput, email);
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        fillInput(passwordInput, password);
        return this;
    }

    public HomePage clickConfirmLoginButton() {
        confirmLoginButton.click();
        return new HomePage();
    }

    public String getLoginError() {
        return failureLoginError.innerText();
    }

    public String getErrorEmailInput() {
        return errorEmailInput.innerText();
    }

}
