package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DialogDivsionAndTeams {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[9]/div/div/div[1]/div/h2")
    WebElement titleSoftwareDevelopment;

    @FindBy(xpath = "/html/body/div[9]/div/button")
    WebElement closeButtonSoftwareDev;

    public DialogDivsionAndTeams(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTitleSoftwareDevVisible() {
        try {
            return titleSoftwareDevelopment.isDisplayed();
        } catch (Exception e) {
            return false; // element not found or not visible
        }
    }

    public String getSoftwareDevTitleText() {
        return titleSoftwareDevelopment.getText();
    }

    public void closePopup() {
        closeButtonSoftwareDev.click();
    }

    public boolean exists() {
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[9]/div/div/div[1]/div/h2"));
        return !elements.isEmpty(); // true if element exists, false if not
    }
}
