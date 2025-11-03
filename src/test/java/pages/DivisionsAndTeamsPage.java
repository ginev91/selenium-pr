package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DivisionsAndTeamsPage {

    @FindBy(xpath = "/html/body/main/article/div/div[7]/div/div/div/div[1]/a/div/div[2]/p")
    WebElement elementSoftwareDevP ;
    @FindBy(xpath = "/html/body/main/article/div/div[7]/div/div/div/div[2]/a/div/div[2]/p")
    WebElement elementTradingPartnerServiceP;

    public DivisionsAndTeamsPage(WebDriver driver) {

        driver.get("https://seeburger.bg/careers/#divisions-and-teams");
        PageFactory.initElements(driver, this);
    }

    public boolean isElementSoftwareDevVisible() {
        return elementSoftwareDevP.isDisplayed();
    }

    public String getSoftwareDevText(){
        return elementSoftwareDevP.getText();
    }

    public void clickSoftwareDevButton() {
        elementSoftwareDevP.click();
    }



//    public boolean isElementTradingPartnerServicesVisible() {
//        return elementTradingPartnerServiceP.isDisplayed();
//    }
//
//    public String getTradingPartnerServicesText(){
//        return elementTradingPartnerServiceP.getText();
//    }


}
