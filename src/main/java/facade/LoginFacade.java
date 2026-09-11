package facade;

import Page.HomePage;
import static config.ConfigReader.*;

public class LoginFacade {

    private final HomePage homePage;

    public LoginFacade() {
        homePage = new HomePage();
    }

    public HomePage login() {
        homePage.clickLoginButton()
                .fillEmailInput(getValidEmail())
                .fillPasswordInput(getValidPassword())
                .clickConfirmLoginButton();
    }

}
