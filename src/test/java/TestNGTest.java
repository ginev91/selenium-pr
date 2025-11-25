import base.BaseDivisionsAndTeamsDialog;
import factory.DialogFactory;
import factory.DialogFactory.DialogType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.DivisionsAndTeamsPage;

import java.util.concurrent.TimeUnit;

public class TestNGTest {

    private static final Logger logger = LogManager.getLogger(TestNGTest.class);
    private WebDriver driver;
    private DivisionsAndTeamsPage divisionsAndTeamsPage;

    @BeforeTest
    public void setup() {
        logger.info("Setting up ChromeDriver...");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ginaleks\\Desktop\\work\\selenium-pr\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        divisionsAndTeamsPage = new DivisionsAndTeamsPage(driver);
        logger.info("Setup complete. Navigated to Divisions & Teams page.");
    }

    @Test
    public void testAllDialogs() {
        logger.info("Starting dialog tests...");

        for (DialogType type : DialogType.values()) {
            logger.info("Testing dialog: {}", type);

            BaseDivisionsAndTeamsDialog dialog = divisionsAndTeamsPage.openDialog(type);

            // Visibility
            Assert.assertTrue(dialog.isVisible(),
                    "Dialog should be visible: " + type);

            // Title text
            String title = dialog.getTitleText();
            logger.info("Dialog title found: {}", title);
            Assert.assertNotNull(title, "Dialog title should not be null for: " + type);
            Assert.assertFalse(title.isEmpty(), "Dialog title should not be empty for: " + type);

            // Body text (if exists)
            String bodyText = dialog.getBodyText();
            if (bodyText != null) {
                logger.info("Dialog body text detected for {}: {}", type, bodyText);
                Assert.assertFalse(bodyText.isEmpty(), "Dialog body text should not be empty: " + type);
            } else {
                logger.warn("No body text locator found for: {}", type);
            }

            // Teams section
            Assert.assertTrue(dialog.isTeamsSectionVisible(),
                    "Teams section should be visible: " + type);

            // Technologies section
            Assert.assertTrue(dialog.isTechSectionVisible(),
                    "Technologies section should be visible: " + type);

            // Close and verify disappearance
            dialog.close();
            Assert.assertFalse(dialog.exists(),
                    "Dialog should be closed and not exist anymore: " + type);

            logger.info("✅ Dialog '{}' passed all checks.", type);
        }

        logger.info("🎉 All dialogs tested successfully.");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            logger.info("Closing browser...");
            driver.quit();
        }
        logger.info("Teardown complete.");
    }
}
