package Page;

import com.microsoft.playwright.Page;


public class BasePage {

    public static Page page;
    private final String validEmail;
    private final String validPassword;
    private final String invalidEmail;
    private final String invalidPassword;
    private final String firstName;
    private final String lastName;

    public BasePage() {
        this.validEmail = "tva428870@gmail.com";
        this.validPassword = "qwerty2111";
        this.invalidEmail = "tva428870gmail.com";
        this.invalidPassword = "qwerty21111";
        this.firstName = "Denys";
        this.lastName = "Dzen";
    }

    // Getters

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
