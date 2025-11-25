package tests;

import base.BaseDivisionsAndTeamsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the "Support Services" dialog.
 * Inherits shared logic and optional locators from BaseDivisionsAndTeamsDialog.
 */
public class SupportServicesDialog extends BaseDivisionsAndTeamsDialog {

    public SupportServicesDialog(WebDriver driver) {
        super(driver,
                // Title element
                By.xpath("//div[@data-dialog-root='other-3']//h2"),

                // Close button
                By.xpath("//div[@data-dialog-root='other-3']//button[contains(@class,'close')]"),

                // Main body paragraph
                By.xpath("//div[@data-dialog-root='other-3']//p"),

                // Teams section
                By.xpath("//div[@data-dialog-root='other-3']//section[@id='teams']"),

                // Technologies section
                By.xpath("//div[@data-dialog-root='other-3']//section[@id='technologies']")
        );
    }
}
