package tests;

import base.BaseDivisionsAndTeamsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the "Software Development" dialog.
 * Inherits shared behaviors from BaseDivisionsAndTeamsDialog.
 */
public class SoftwareDevDialog extends BaseDivisionsAndTeamsDialog {

    public static final String EXPECTED_TITLE = "Software Development";
    public static final String EXPECTED_BODY = "Your main paragraph mockup text here";
    public static final String EXPECTED_TEAMS_SECTION_TEXT = "Teams section mockup text";
    public static final String EXPECTED_TECH_SECTION_TEXT = "Technologies section mockup text";

    public SoftwareDevDialog(WebDriver driver) {
        super(driver,
                // Title element
                By.xpath("/html/body/div[9]/div/div/div[1]/div/h2"),

                // Close button
                By.xpath("/html/body/div[9]/div/button"),

                // Main body paragraph
                By.xpath("//div[@data-dialog-root='software-development']//p"),

                // Teams section
                By.xpath("//div[@data-dialog-root='software-development']//section[@id='teams']"),

                // Technologies section
                By.xpath("//div[@data-dialog-root='software-development']//section[@id='technologies']")
        );
    }
}
