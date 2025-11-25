package factory;

import base.BaseDivisionsAndTeamsDialog;
import tests.CloudServicesDialog;
import tests.SoftwareDevDialog;
import tests.SupportServicesDialog;
import tests.TradingPartnerServicesDialog;
import org.openqa.selenium.WebDriver;

public class DialogFactory {

    public enum DialogType {
        SOFTWARE_DEV,
        TRADING_PARTNER_SERVICES,
        CLOUD_SERVICES,
        SUPPORT_SERVICES
    }

    /**
     * Returns the correct dialog instance based on type.
     * Each dialog extends BaseDivisionsAndTeamsDialog.
     */
    public static BaseDivisionsAndTeamsDialog create(WebDriver driver, DialogType type) {
        switch (type) {
            case SOFTWARE_DEV:
                return new SoftwareDevDialog(driver);
            case TRADING_PARTNER_SERVICES:
                return new TradingPartnerServicesDialog(driver);
            case CLOUD_SERVICES:
                return new CloudServicesDialog(driver);
            case SUPPORT_SERVICES:
                return new SupportServicesDialog(driver);
            default:
                throw new IllegalArgumentException("Unknown dialog type: " + type);
        }
    }
}
