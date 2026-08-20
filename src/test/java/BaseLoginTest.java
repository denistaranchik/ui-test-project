import Constant.Errors;
import Page.BasePage;
import config.ConfigReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import listeners.ScreenshotListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class BaseLoginTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseLoginTest.class);

    public Playwright playwright;
    public Browser browser;

    @BeforeMethod
    public void setUp() {
        logger.info("=== Starting browser, headless={} ===", ConfigReader.isHeadless());

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(ConfigReader.isHeadless())
        );
        BasePage.page = browser.newPage();
        BasePage.page.navigate(ConfigReader.getBaseUrl());

        logger.info("Navigated to {}", ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {

        logger.info("=== Closing browser ===");

        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @DataProvider(name = "RegistrationData")
    public Object[][] registrationData() {
        return new Object[][]{
                {ConfigReader.getMaleGender(),
                        ConfigReader.getFirstName(),
                        ConfigReader.getLastName(),
                        ConfigReader.getValidEmail()},

                {ConfigReader.getFemaleGender(),
                        ConfigReader.getFirstName(),
                        ConfigReader.getLastName(),
                        ConfigReader.getValidEmail()},
        };
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {ConfigReader.getNonExistEmail(),
                        ConfigReader.getValidPassword(),
                        Errors.LOGIN_ERROR_MESSAGE
                },

                {ConfigReader.getValidEmail(),
                        ConfigReader.getInvalidPassword(),
                        Errors.LOGIN_ERROR_MESSAGE
                },
        };
    }
}
