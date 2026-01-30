package dialogs;

import base.BaseDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloudServicesDialog extends BaseDialog {

    public static final String EXPECTED_TITLE = "Cloud Services";
    public static final String EXPECTED_SUB_TITLE = "Deliver high-quality and secure integration services";
    public static final String EXPECTED_BODY = "SEEBURGER Group Cloud Integration is designed to run in any cloud environment. Whether it’s the client’s, ours, AWS, Azure, GCP, or another public cloud – our Cloud Services team is always ready to deliver unmatched integration services. The service operation lifecycle includes handling user requests, resolving service disruptions, fixing issues, and performing routine operational tasks.";
    public static final String EXPECTED_TEAMS_SECTION_TEXT = "Operations, Technical Product Support, Release Management, Service Management, Event Management, Go-live Management, Problem Management";
    public static final String EXPECTED_TECH_SECTION_TEXT = "ITIL-based Incident & Change tools, Windows server, Linux Redhat server, MS SQL server, Oracle enterprise, Icinga, Nagios, Python, PowerShell, REST, various TCP-based protocols, Grafana, Prometheus, SSL-based certificates, etc.";

    public CloudServicesDialog(WebDriver driver) {
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
