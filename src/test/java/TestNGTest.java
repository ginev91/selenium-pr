import base.BaseDialog;
import dialogs.*;
import factory.DialogFactory.DialogType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import page.DivisionsAndTeamsPage;

import java.util.concurrent.TimeUnit;

public class TestNGTest {

    private static final Logger logger = LogManager.getLogger(TestNGTest.class);
    private WebDriver driver;
    private DivisionsAndTeamsPage divisionsAndTeamsPage;

    @BeforeTest
    public void setup() {
        logger.info("🚀 Setting up ChromeDriver...");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        divisionsAndTeamsPage = new DivisionsAndTeamsPage(driver);
        logger.info("✅ Setup complete.  Navigated to Divisions & Teams page.");
    }

    @DataProvider(name = "dialogTypes")
    public Object[][] dialogTypes() {
        return new Object[][] {
                { DialogType.SOFTWARE_DEV },
                { DialogType.TRADING_PARTNER_SERVICES },
                { DialogType.CLOUD_SERVICES },
                { DialogType.SUPPORT_SERVICES }
        };
    }

    @Test(dataProvider = "dialogTypes")
    public void testDialog(DialogType type) {
        logger.info("========================================");
        logger.info("Testing dialog: {}", type);
        logger.info("========================================");

        testDialogCompletely(type);

        logger.info("✅ Dialog '{}' passed ALL checks.\n", type);
    }

    private void testDialogCompletely(DialogType type) {

        ExpectedDialogData expectedData = getExpectedData(type);

        BaseDialog dialog = divisionsAndTeamsPage.openDialog(type);

        logger.info("Test 1: Checking dialog visibility...");
        Assert.assertTrue(dialog.isVisible(), "Dialog should be visible:  " + type);
        logger.info("✅ isVisible() = true");

        logger.info("Test 2: Checking dialog exists in DOM...");
        Assert.assertTrue(dialog.exists(), "Dialog should exist in DOM: " + type);
        logger.info("✅ exists() = true");

        logger.info("Test 3: Getting title text...");
        String actualTitle = dialog.getTitleText();
        logger.info("📋 Actual Title: '{}'", actualTitle);
        Assert.assertNotNull(actualTitle, "Title should not be null");
        logger.info("✅ getTitleText() returned value");

        logger.info("Test 4: Verifying title matches expected...");
        logger.info("📋 Expected Title: '{}'", expectedData.title);
        Assert.assertEquals(actualTitle, expectedData.title,
                "Title should match EXPECTED_TITLE");
        logger.info("✅ Title matches expected!");

        logger.info("Test 5: Checking subtitle visibility...");
        boolean hasSubtitle = dialog.isSubTitleVisible();
        logger.info("📌 isSubTitleVisible() = {}", hasSubtitle);

        if (expectedData.subTitle != null) {
            logger.info("Test 6: Getting and verifying subtitle.. .");
            Assert.assertTrue(hasSubtitle, "Subtitle should be visible");

            String actualSubTitle = dialog.getSubTitleText();
            logger.info("📋 Actual Subtitle: '{}'", actualSubTitle);
            logger.info("📋 Expected Subtitle: '{}'", expectedData.subTitle);
            Assert.assertEquals(actualSubTitle, expectedData.subTitle,
                    "Subtitle should match EXPECTED_SUB_TITLE");
            logger.info("✅ Subtitle matches expected!");
        } else {
            logger.info("⚠️ Test 6: No subtitle expected (skipped)");
        }

        logger.info("Test 7: Getting and verifying body text...");
        String actualBody = dialog.getBodyText();
        if (actualBody != null && !actualBody.trim().isEmpty()) {
            logger.info("📝 Actual Body (first 100 chars): '{}'",
                    actualBody.substring(0, Math.min(100, actualBody.length())) + "...");

            if (expectedData.body != null) {
                logger.info("📋 Expected Body (first 100 chars): '{}'",
                        expectedData.body.substring(0, Math.min(100, expectedData.body.length())) + "...");
                Assert.assertEquals(actualBody, expectedData.body,
                        "Body text should match EXPECTED_BODY");
                logger.info("✅ Body text matches expected!");
            } else {
                logger.info("✅ Body text found (no expected value to compare)");
            }
        } else {
            logger.warn("⚠️ No body text found");
        }

        logger.info("Test 8: Checking Teams section visibility...");
        boolean hasTeams = dialog.isTeamsSectionVisible();
        logger.info("👥 isTeamsSectionVisible() = {}", hasTeams);
        Assert.assertTrue(hasTeams, "Teams section should be visible");
        logger.info("✅ Teams section is visible");

        if (expectedData.teamsText != null) {
            logger.info("Test 9: Verifying Teams section text...");
            logger.info("📋 Expected Teams:  '{}'", expectedData.teamsText);
            logger.info("✅ Teams section present (text verification would need getTeamsSectionText() method)");
        }

        logger.info("Test 10: Checking Technologies section visibility...");
        boolean hasTech = dialog.isTechSectionVisible();
        logger.info("⚙️ isTechSectionVisible() = {}", hasTech);
        Assert.assertTrue(hasTech, "Technologies section should be visible");
        logger.info("✅ Technologies section is visible");

        if (expectedData.techText != null) {
            logger.info("Test 11: Verifying Technologies section text...");
            logger.info("📋 Expected Tech: '{}'", expectedData.techText);
            logger.info("✅ Tech section present (text verification would need getTechSectionText() method)");
        }

        logger.info("Test 12: Closing dialog...");
        dialog.close();
        try { Thread.sleep(500); } catch (InterruptedException e) { }
        logger.info("✅ close() executed");

        logger.info("Test 13: Verifying dialog removed from DOM...");
        Assert.assertFalse(dialog.exists(), "Dialog should NOT exist after closing");
        logger.info("✅ exists() = false");

        logger.info("Test 14: Verifying dialog not visible.. .");
        Assert.assertFalse(dialog.isVisible(), "Dialog should NOT be visible");
        logger.info("✅ isVisible() = false");
    }

    /**
     * Helper class to hold expected data
     */
    private static class ExpectedDialogData {
        String title;
        String subTitle;
        String body;
        String teamsText;
        String techText;

        ExpectedDialogData(String title, String subTitle, String body,
                           String teamsText, String techText) {
            this.title = title;
            this.subTitle = subTitle;
            this.body = body;
            this.teamsText = teamsText;
            this.techText = techText;
        }
    }

    /**
     * Get expected data from dialog class constants
     */
    private ExpectedDialogData getExpectedData(DialogType type) {
        switch (type) {
            case SOFTWARE_DEV:
                return new ExpectedDialogData(
                        SoftwareDevDialog.EXPECTED_TITLE,
                        SoftwareDevDialog.EXPECTED_SUB_TITLE,
                        SoftwareDevDialog.EXPECTED_BODY,
                        SoftwareDevDialog.EXPECTED_TEAMS_SECTION_TEXT,
                        SoftwareDevDialog.EXPECTED_TECH_SECTION_TEXT
                );
            case TRADING_PARTNER_SERVICES:
                return new ExpectedDialogData(
                        TradingPartnerServicesDialog.EXPECTED_TITLE,
                        TradingPartnerServicesDialog.EXPECTED_SUB_TITLE,
                        TradingPartnerServicesDialog.EXPECTED_BODY,
                        TradingPartnerServicesDialog.EXPECTED_TEAMS_SECTION_TEXT,
                        TradingPartnerServicesDialog.EXPECTED_TECH_SECTION_TEXT
                );
            case CLOUD_SERVICES:
                return new ExpectedDialogData(
                        CloudServicesDialog.EXPECTED_TITLE,
                        CloudServicesDialog.EXPECTED_SUB_TITLE,
                        CloudServicesDialog.EXPECTED_BODY,
                        CloudServicesDialog.EXPECTED_TEAMS_SECTION_TEXT,
                        CloudServicesDialog.EXPECTED_TECH_SECTION_TEXT
                );
            case SUPPORT_SERVICES:
                return new ExpectedDialogData(
                        SupportServicesDialog.EXPECTED_TITLE,
                        SupportServicesDialog.EXPECTED_SUB_TITLE,
                        SupportServicesDialog.EXPECTED_BODY,
                        SupportServicesDialog.EXPECTED_TEAMS_SECTION_TEXT,
                        SupportServicesDialog.EXPECTED_TECH_SECTION_TEXT
                );
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            logger.info("🔒 Closing browser...");
            driver.quit();
        }
        logger.info("✅ Teardown complete.");
    }
}