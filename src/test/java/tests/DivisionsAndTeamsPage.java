package tests;

import base.BaseDivisionsAndTeamsDialog;
import factory.DialogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DivisionsAndTeamsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    private final By btnSoftwareDev = By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[1]/a/div/div[2]/p");
    private final By btnTradingPartnerServices = By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[2]/a/div/div[2]/p");
    private final By btnCloudServices = By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[3]/a/div/div[2]/p");
    private final By btnSupportServices = By.xpath("/html/body/main/article/div/div[7]/div/div/div/div[4]/a/div/div[2]/p");

    public DivisionsAndTeamsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        driver.get("https://seeburger.bg/careers/#divisions-and-teams");
        PageFactory.initElements(driver, this);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public BaseDivisionsAndTeamsDialog openDialog(DialogFactory.DialogType type) {
        switch (type) {
            case SOFTWARE_DEV:
                click(btnSoftwareDev);
                break;
            case TRADING_PARTNER_SERVICES:
                click(btnTradingPartnerServices);
                break;
            case CLOUD_SERVICES:
                click(btnCloudServices);
                break;
            case SUPPORT_SERVICES:
                click(btnSupportServices);
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        return DialogFactory.create(driver, type);
    }
}
