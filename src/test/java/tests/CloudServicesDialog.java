package tests;

import base.BaseDivisionsAndTeamsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the "Cloud Services" dialog.
 * Inherits shared behaviors and optional locators from BaseDivisionsAndTeamsDialog.
 */
public class CloudServicesDialog extends BaseDivisionsAndTeamsDialog {

    public CloudServicesDialog(WebDriver driver) {
        super(driver,
                // Title element
                By.xpath("//div[@data-dialog-root='other-2']//h2"),

                // Close button
                By.xpath("//div[@data-dialog-root='other-2']//button[contains(@class,'close')]"),

                // Main body paragraph
                By.xpath("//div[@data-dialog-root='other-2']//p"),

                // Teams section
                By.xpath("//div[@data-dialog-root='other-2']//section[@id='teams']"),

                // Technologies section
                By.xpath("//div[@data-dialog-root='other-2']//section[@id='technologies']")
        );
    }
}
