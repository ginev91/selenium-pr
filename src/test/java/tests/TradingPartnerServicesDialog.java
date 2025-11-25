package tests;

import base.BaseDivisionsAndTeamsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the "Trading Partner Services" dialog.
 * Extends BaseDivisionsAndTeamsDialog to reuse all shared dialog logic.
 */
public class TradingPartnerServicesDialog extends BaseDivisionsAndTeamsDialog {

    public TradingPartnerServicesDialog(WebDriver driver) {
        super(driver,
                // Title element
                By.xpath("//div[@data-dialog-root='other-1']//h2"),

                // Close button
                By.xpath("//div[@data-dialog-root='other-1']//button[contains(@class,'close')]"),

                // Main body paragraph
                By.xpath("//div[@data-dialog-root='other-1']//p"),

                // Teams section
                By.xpath("//div[@data-dialog-root='other-1']//section[@id='teams']"),

                // Technologies section
                By.xpath("//div[@data-dialog-root='other-1']//section[@id='technologies']")
        );
    }
}
