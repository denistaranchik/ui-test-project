package listeners;

import Page.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener implements ITestListener {

    private static final String SCREENSHOT_DIR = "screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        Page page = BasePage.page;
        if (page == null) {
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = result.getName() + "_" + timestamp + ".png";
        Path path = Paths.get(SCREENSHOT_DIR, fileName);

        page.screenshot(new Page.ScreenshotOptions().setPath(path).setType(ScreenshotType.PNG).setFullPage(true));

        System.out.println("Failure screenshot saved: " + path.toAbsolutePath());
    }
}
