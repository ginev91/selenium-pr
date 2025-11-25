package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseElement {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected static final Duration TIMEOUT = Duration.ofSeconds(5);

    protected BaseElement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }
}
