package Page;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class Helper {

    // Method for random mail generation

    public String randomMailGenerator() {
        Random random = new Random();
        int randomEmailNumber = random.nextInt(1000000000);
        String randomEmail = RandomStringUtils.secure().nextAlphabetic(5);
        return "DZEN" + randomEmail + "+" + randomEmailNumber + "@fakemail.com";
    }
}
