import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DialogDivsionAndTeams;
import pages.DivisionsAndTeamsPage;

import java.util.concurrent.TimeUnit;

public class TestNGTest {

    Logger logger = LogManager.getLogger(TestNGTest.class);
    WebDriver driver;
    DivisionsAndTeamsPage divisionsAndTeamsPage;
    DialogDivsionAndTeams dialogDivsionAndTeams;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ginaleks\\Desktop\\work\\selenium-pr\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        divisionsAndTeamsPage = new DivisionsAndTeamsPage(driver);
        dialogDivsionAndTeams = new DialogDivsionAndTeams(driver);
    }
    @Test
    public void executeTest() {
        logger.info("First test set up");

        String expectedTitle = "Software Development";

        Assert.assertEquals(divisionsAndTeamsPage.getSoftwareDevText(), expectedTitle.toUpperCase());
        Assert.assertTrue(divisionsAndTeamsPage.isElementSoftwareDevVisible());

        divisionsAndTeamsPage.clickSoftwareDevButton();
        Assert.assertTrue(dialogDivsionAndTeams.isTitleSoftwareDevVisible());
        Assert.assertEquals(dialogDivsionAndTeams.getSoftwareDevTitleText(), expectedTitle);
        dialogDivsionAndTeams.closePopup();
        Assert.assertFalse(dialogDivsionAndTeams.exists());

        logger.info("Test FINISHED");
    }

//    @Test
//    public void executeTest2() {
//
//        String expectedTitle = "Trading Partner Services";
//
//        Assert.assertEquals(divisionsAndTeamsPage.getTradingPartnerServicesText(), expectedTitle.toUpperCase());
//        Assert.assertTrue(divisionsAndTeamsPage.isElementTradingPartnerServicesVisible());
//
//    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
