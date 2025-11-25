package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Base dialog for Divisions and Teams section.
 * Contains all common functionality for all dialogs:
 *  - Title
 *  - Body text
 *  - Teams section
 *  - Technologies section
 *  - Visibility and close handling
 */
public abstract class BaseDivisionsAndTeamsDialog {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected static final Duration TIMEOUT = Duration.ofSeconds(5);

    // Common locators for elements that may or may not exist
    protected final By titleLocator;
    protected final By closeLocator;
    protected final By bodyLocator;
    protected final By teamsSectionLocator;
    protected final By techSectionLocator;

    protected BaseDivisionsAndTeamsDialog(WebDriver driver,
                                          By titleLocator,
                                          By closeLocator,
                                          By bodyLocator,
                                          By teamsSectionLocator,
                                          By techSectionLocator) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        this.titleLocator = titleLocator;
        this.closeLocator = closeLocator;
        this.bodyLocator = bodyLocator;
        this.teamsSectionLocator = teamsSectionLocator;
        this.techSectionLocator = techSectionLocator;
    }

    /**
     * Checks if the dialog title is visible. Returns true if locator is missing.
     */
    public boolean isVisible() {
        if (titleLocator == null) return true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the dialog title text if present.
     */
    public String getTitleText() {
        if (titleLocator == null) return null;
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return el.getText();
    }

    /**
     * Gets the body/paragraph text if present.
     */
    public String getBodyText() {
        if (bodyLocator == null) return null;
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(bodyLocator));
        return el.getText();
    }

    /**
     * Returns true if the Teams section is visible.
     */
    public boolean isTeamsSectionVisible() {
        if (teamsSectionLocator == null) return false;
        List<WebElement> elems = driver.findElements(teamsSectionLocator);
        return !elems.isEmpty() && elems.get(0).isDisplayed();
    }

    /**
     * Returns true if the Technologies section is visible.
     */
    public boolean isTechSectionVisible() {
        if (techSectionLocator == null) return false;
        List<WebElement> elems = driver.findElements(techSectionLocator);
        return !elems.isEmpty() && elems.get(0).isDisplayed();
    }

    /**
     * Closes the dialog if closeLocator is provided.
     */
    public void close() {
        if (closeLocator == null) return;
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeLocator));
            closeBtn.click();
            if (titleLocator != null) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(titleLocator));
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Checks if the dialog still exists in the DOM.
     */
    public boolean exists() {
        if (titleLocator == null) return false;
        return !driver.findElements(titleLocator).isEmpty();
    }

    public boolean textMatches(By locator, String expectedText) {
        if (locator == null) return false;
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return el.getText().equals(expectedText);
        } catch (Exception e) {
            return false;
        }
    }
}
