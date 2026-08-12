package Page;

import com.microsoft.playwright.Locator;
import java.util.Random;

public class RegistrationPage {


    private final Locator genderMaleRadioButton = BasePage.page.locator("#gender-male");
    private final Locator genderFemaleRadioButton = BasePage.page.locator("gender-female");
    private final Locator firstNameInput = BasePage.page.locator("#FirstName");
    private final Locator lastNameInput = BasePage.page.locator("#LastName");
    private final Locator emailInput = BasePage.page.locator("#Email");

    private final Locator passwordInput = BasePage.page.locator("#Password");
    private final Locator confirmPasswordInput = BasePage.page.locator("#ConfirmPassword");
    private final Locator registrationButton = BasePage.page.locator("#register-button");


    // Click methods

    public void clickGenderMaleRadioButton() {
        genderMaleRadioButton.click();
    }

    public void clickGenderFemaleRadioButton() {
        genderFemaleRadioButton.click();
    }

    public void clickFirstNameInput() {
        firstNameInput.click();
    }

    public void clickLastNameInput() {
        lastNameInput.click();
    }

    public void clickEmailInput() {
        emailInput.click();
    }

    public void passwordInput() {
        passwordInput.click();
    }

    public void confirmPasswordInput() {
        confirmPasswordInput.click();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    // Fill methods

    public void fillFirstNameInput(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void fillLastNameInput(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void fillEmailInput(String email) {
        emailInput.fill(email);
    }

    public void fillPasswordInput(String password) {
        passwordInput.fill(password);
    }

    public void fillConfirmPasswordInput(String confirmPassword) {
        confirmPasswordInput.fill(confirmPassword);
    }

    // Method for random mail generation

    public String randomMailGenerator() {
        Random random = new Random();
        int number = random.nextInt(1000000000);
        return "tva428870+" + number + "@gmail.com";
    }
}

