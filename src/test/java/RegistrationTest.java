import Constant.Buttons;
import Constant.Credentials;
import Constant.UserData;
import Page.HomePage;
import Page.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseLoginTest {

    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void successfulRegistrationMaleTest() {

        String generatedRandomEmail = registrationPage.randomMailGenerator();

        homePage.clickRegistrationButton()
                .clickGenderMaleRadioButton()
                .fillFirstNameInput(UserData.FIRSTNAME.getUserData())
                .fillLastNameInput(UserData.LASTNAME.getUserData())
                .fillEmailInput(generatedRandomEmail)
                .fillPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .fillConfirmPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .clickRegistrationButton();

        assertEquals(homePage.getCustomerInfoText(), generatedRandomEmail);
        assertEquals(homePage.checkLogOutButtonPresence(), Buttons.LOGOUT.getButtonName());

    }

    @Test
    public void successfulRegistrationFemaleTest() {

        String generatedRandomEmail = registrationPage.randomMailGenerator();

        homePage.clickRegistrationButton()
                .clickGenderFemaleRadioButton()
                .fillFirstNameInput(UserData.FIRSTNAME.getUserData())
                .fillLastNameInput(UserData.LASTNAME.getUserData())
                .fillEmailInput(generatedRandomEmail)
                .fillPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .fillConfirmPasswordInput(Credentials.VALID_PASSWORD.getCredentials())
                .clickRegistrationButton();

        assertEquals(homePage.getCustomerInfoText(), generatedRandomEmail);
        assertEquals(homePage.checkLogOutButtonPresence(), Buttons.LOGOUT.getButtonName());

    }
}
