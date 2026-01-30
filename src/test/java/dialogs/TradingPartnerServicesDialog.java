package dialogs;

import base.BaseDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the "Trading Partner Services" dialog.
 * Extends BaseDivisionsAndTeamsDialog to reuse all shared dialog logic.
 */
public class TradingPartnerServicesDialog extends BaseDialog {

    public static final String EXPECTED_TITLE = "Trading Partner Services";
    public static final String EXPECTED_SUB_TITLE = "Combining technical precision with clear, consistent communication";
    public static final String EXPECTED_BODY = "Our Trading Partner Services team ensures the growth of our customers’ trading partner ecosystems. Their EDI connections and partner relationships are established, maintained, compliant, and future-ready. From initial onboarding to ongoing support, we build and sustain the critical links that enable smooth and secure data exchange between our clients and their trading partners.";
    public static final String EXPECTED_TEAMS_SECTION_TEXT = "Trading Partner Support, Trading Partner Helpdesk, Cloud Request Fulfillment, Problem management, Service Management";
    public static final String EXPECTED_TECH_SECTION_TEXT = "ITSM, ServiceNow, Certificates, SSH Keys, Azure Blob Storage, Google Cloud Storage – Buckets, Azure File Service, Access Tokens, VMWare, Citrix Workplace";

    public TradingPartnerServicesDialog(WebDriver driver) {
        super(driver,

                By.xpath("/html/body/div[9]/div/div/div[1]/div/h2"),

                By.xpath("/html/body/div[9]/div/div/div[1]/div/p[1]/strong"),

                By.xpath("/html/body/div[9]/div/button"),

                By.xpath("/html/body/div[9]/div/div/div[1]/div/p[2]"),

                By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[1]/p[2]"),

                By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[2]/p[2]")
        );
    }
}
