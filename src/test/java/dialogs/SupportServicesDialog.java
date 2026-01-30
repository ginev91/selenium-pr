package dialogs;

import base.BaseDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportServicesDialog extends BaseDialog {

    public static final String EXPECTED_TITLE = "Support Services";
    public static final String EXPECTED_SUB_TITLE = "24/7 availability, customer care, reliability, reachability, fast solutions";
    public static final String EXPECTED_BODY = "Here comes the team that never sleeps.No matter the field or the size of the business, critical issues can pop up at any time and cause serious trouble. That’s where we’ve got our clients’ backs. SEEBURGER’s dedicated engineers work around the clock to make sure things get resolved quickly — 24/7.";
    public static final String EXPECTED_TEAMS_SECTION_TEXT = "Technical Product Support,\n" +
            "Remote Managed Services,\n" +
            "Service Management";
    public static final String EXPECTED_TECH_SECTION_TEXT = "Java, Grafana, Prometheus, ITSM, MS Teams, SQL, Windows server, Linux, VMWare, SAP, Amazon AWS/Microsoft Azure/Google Cloud, REST API, Webservices, Open Project";

    public SupportServicesDialog(WebDriver driver) {
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
