package dialogs;

import base.BaseDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoftwareDevDialog extends BaseDialog {

    public static final String EXPECTED_TITLE = "Software Development";
    public static final String EXPECTED_SUB_TITLE = "Develop the SEEBURGER state-of-the-art integration platform";
    public static final String EXPECTED_BODY = "Our software development team is distributed across Germany, Bulgaria, and India. Armed with cutting-edge tools and technologies, and guided by an agile development process, we are shaping the future of business integration worldwide. Whether we’re building our scalable distributed platform, connecting partners and services, transforming sensitive data, or creating end-user applications, we are driven by one core principle: to build secure and reliable software.";
    public static final String EXPECTED_TEAMS_SECTION_TEXT = "Backend Developer, Full-stack Developer, Automation Developer,\n" +
            "DevOps Expert, UI/UX Designer, Agile Master, Product Owner,\n" +
            "System Architect";
    public static final String EXPECTED_TECH_SECTION_TEXT = "Java, Angular, AWS, Kubernetes, Docker, OSGi, Jenkins, Maven, Git";

    public SoftwareDevDialog(WebDriver driver) {
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
