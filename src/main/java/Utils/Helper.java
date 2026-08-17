package Utils;

import Page.BasePage;
import org.apache.commons.lang3.RandomStringUtils;

public class Helper extends BasePage {

    public static String randomMailGenerator() {
        String randomNumbers = RandomStringUtils.secure().nextNumeric(5);
        String randomLetters = RandomStringUtils.secure().nextAlphabetic(5);
        return "DZEN" + randomLetters + "+" + randomNumbers + "@fakemail.com";
    }

}
