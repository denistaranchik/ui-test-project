import Utils.Helper;
import Page.HomePage;
import Page.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constant.Buttons.LOGOUT;
import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseLoginTest {

    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        registrationPage = new RegistrationPage();
    }

    @Test(dataProvider = "RegistrationData")
    public void successfulRegistrationTest(String gender, String firstName, String lastName,
                                            String password) {

        String generatedRandomEmail = Helper.randomMailGenerator();

        homePage.clickRegistrationButton()
                .clickGenderRadioButton(gender)
                .fillFirstNameInput(firstName)
                .fillLastNameInput(lastName)
                .fillEmailInput(generatedRandomEmail)
                .fillPasswordInput(password)
                .fillConfirmPasswordInput(password)
                .clickConfirmRegistrationButton();

        assertEquals(homePage.getCustomerInfoText(), generatedRandomEmail, "Customer email" +
                " should be displayed in header after successful registration");
        assertEquals(homePage.checkLogOutButtonPresence(), LOGOUT.getButtonName(), "Logout button" +
                " should be visible after successful registration");

    }
}
