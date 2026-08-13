package Page;

import com.microsoft.playwright.Locator;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;


public class RegistrationPage {

    private final Locator genderMaleRadioButton = BasePage.page.locator("#gender-male");
    private final Locator genderFemaleRadioButton = BasePage.page.locator("#gender-female");
    private final Locator firstNameInput = BasePage.page.locator("#FirstName");
    private final Locator lastNameInput = BasePage.page.locator("#LastName");
    private final Locator emailInput = BasePage.page.locator("#Email");

    private final Locator passwordInput = BasePage.page.locator("#Password");
    private final Locator confirmPasswordInput = BasePage.page.locator("#ConfirmPassword");
    private final Locator registrationButton = BasePage.page.locator("#register-button");


    // Click methods

    public RegistrationPage clickGenderMaleRadioButton() {
        genderMaleRadioButton.click();
        return this;
    }

    public RegistrationPage clickGenderFemaleRadioButton() {
        genderFemaleRadioButton.click();
        return this;
    }

    public HomePage clickRegistrationButton() {
        registrationButton.click();
        return new HomePage();
    }

    // Fill methods

    public RegistrationPage fillFirstNameInput(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    public RegistrationPage fillLastNameInput(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    public RegistrationPage fillEmailInput(String email) {
        emailInput.fill(email);
        return this;
    }

    public RegistrationPage fillPasswordInput(String password) {
        passwordInput.fill(password);
        return this;
    }

    public RegistrationPage fillConfirmPasswordInput(String confirmPassword) {
        confirmPasswordInput.fill(confirmPassword);
        return this;
    }

    // Method for random mail generation

    public String randomMailGenerator() {
        Random random = new Random();
        int randomEmailNumber = random.nextInt(1000000000);
        String randomEmail = RandomStringUtils.secure().nextAlphabetic(5);
        return "DZEN" + randomEmail + "+" + randomEmailNumber + "@fakemail.com";
    }
}

