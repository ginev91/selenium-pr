package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging. log4j.Logger;
import org.openqa.selenium.By;
import org.openqa. selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa. selenium.support.ui.ExpectedConditions;
import org. openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseDialog {

    protected static final Logger logger = LogManager. getLogger(BaseDialog.class);
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected static final Duration TIMEOUT = Duration.ofSeconds(5);

    protected final By titleLocator;
    protected final By subTitleLocator;
    protected final By closeLocator;
    protected final By bodyLocator;
    protected final By teamsSectionLocator;
    protected final By techSectionLocator;

    protected BaseDialog(WebDriver driver,
                         By titleLocator,
                         By subTitleLocator,
                         By closeLocator,
                         By bodyLocator,
                         By teamsSectionLocator,
                         By techSectionLocator) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        this.titleLocator = titleLocator;
        this.subTitleLocator = subTitleLocator;
        this.closeLocator = closeLocator;
        this. bodyLocator = bodyLocator;
        this.teamsSectionLocator = teamsSectionLocator;
        this.techSectionLocator = techSectionLocator;
    }

    protected boolean isElementVisible(By locator) {
        if (locator == null) return false;
        try {
            wait.until(ExpectedConditions. visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected String getElementText(By locator) {
        if (locator == null) return null;
        try {
            WebElement el = wait.until(ExpectedConditions. visibilityOfElementLocated(locator));
            return el. getText();
        } catch (Exception e) {
            logger.warn("Could not get text from locator: {}", locator);
            return null;
        }
    }


    protected boolean isElementDisplayed(By locator) {
        if (locator == null) return false;
        List<WebElement> elems = driver.findElements(locator);
        return !elems.isEmpty() && elems.get(0).isDisplayed();
    }


    protected boolean elementExists(By locator) {
        if (locator == null) return false;
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isVisible() {
        return isElementVisible(titleLocator);
    }

    public String getTitleText() {
        return getElementText(titleLocator);
    }

    public boolean isSubTitleVisible() {
        return isElementVisible(subTitleLocator);
    }

    public String getSubTitleText() {
        return getElementText(subTitleLocator);
    }

    public String getBodyText() {
        return getElementText(bodyLocator);
    }

    public boolean isTeamsSectionVisible() {
        return isElementDisplayed(teamsSectionLocator);
    }

    public boolean isTechSectionVisible() {
        return isElementDisplayed(techSectionLocator);
    }

    public void close() {
        if (closeLocator == null) {
            logger.warn("No close locator defined");
            return;
        }
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeLocator));
            closeBtn.click();

            if (titleLocator != null) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(titleLocator));
            }
        } catch (Exception e) {
            logger.error("Failed to close dialog", e);
        }
    }

    public boolean exists() {
        return elementExists(titleLocator);
    }

    public boolean textMatches(By locator, String expectedText) {
        String actualText = getElementText(locator);
        return actualText != null && actualText.equals(expectedText);
    }
}