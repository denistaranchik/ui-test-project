package Page;

import com.microsoft.playwright.Locator;

public class RegistrationPage extends BasePage {

    private final Locator genderMaleRadioButton = BasePage.page.locator("#gender-male");
    private final Locator genderFemaleRadioButton = BasePage.page.locator("#gender-female");
    private final Locator firstNameInput = BasePage.page.locator("#FirstName");
    private final Locator lastNameInput = BasePage.page.locator("#LastName");
    private final Locator confirmPasswordInput = BasePage.page.locator("#ConfirmPassword");
    private final Locator confirmRegistrationButton = BasePage.page.locator("#register-button");

    public RegistrationPage clickGenderRadioButton(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            genderMaleRadioButton.click();
            return this;
        } else {
            genderFemaleRadioButton.click();
            return this;
        }
    }

    public HomePage clickConfirmRegistrationButton() {
        confirmRegistrationButton.click();
        return new HomePage();
    }

    public RegistrationPage fillFirstNameInput(String firstName) {
        fillInput(firstNameInput, firstName);
        return this;
    }

    public RegistrationPage fillLastNameInput(String lastName) {
        fillInput(lastNameInput, lastName);
        return this;
    }

    public RegistrationPage fillEmailInput(String email) {
        fillInput(emailInput, email);
        return this;
    }

    public RegistrationPage fillPasswordInput(String password) {
        fillInput(passwordInput, password);
        return this;
    }

    public RegistrationPage fillConfirmPasswordInput(String confirmPassword) {
        fillInput(confirmPasswordInput, confirmPassword);
        return this;
    }
}

