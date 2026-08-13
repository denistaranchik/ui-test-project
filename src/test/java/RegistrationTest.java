import Constant.Buttons;
import Constant.Credentials;
import Constant.UserData;
import Page.Helper;
import Page.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseLoginTest {

    HomePage homePage;
    Helper helper;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        helper = new Helper();
    }

    @Test
    public void successfulRegistrationMaleTest() {

        String generatedRandomEmail = helper.randomMailGenerator();

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

        String generatedRandomEmail = helper.randomMailGenerator();

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
