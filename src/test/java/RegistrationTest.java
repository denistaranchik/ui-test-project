import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import Page.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseLoginTest {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    BasePage basePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        basePage = new BasePage();
    }

    @Test
    public void successfulRegistrationTest() {

        String generatedRandomEmail = registrationPage.randomMailGenerator();

        homePage.clickRegistrationButton();
        registrationPage.clickGenderMaleRadioButton();
        registrationPage.fillFirstNameInput(basePage.getFirstName());
        registrationPage.fillLastNameInput(basePage.getLastName());
        registrationPage.fillEmailInput(generatedRandomEmail);
        registrationPage.fillPasswordInput(basePage.getValidPassword());
        registrationPage.fillConfirmPasswordInput(basePage.getValidPassword());
        registrationPage.clickRegistrationButton();

        String actualCustomerInfoAfterRegistration = homePage.getCustomerInfoText();
        assertEquals(actualCustomerInfoAfterRegistration, generatedRandomEmail);
    }
}
