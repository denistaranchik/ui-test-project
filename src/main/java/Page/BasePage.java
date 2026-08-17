package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    public final Locator emailInput = BasePage.page.locator("#Email");
    public final Locator passwordInput = BasePage.page.locator("#Password");

    public static void fillInput(Locator locator, String string) {
        locator.fill(string);
    }

    public static Page page;

}