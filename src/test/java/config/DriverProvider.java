package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class DriverProvider {

    static TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    public static void applyConfig(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.baseUrl = testConfig.getBaseurl();
        Configuration.browserSize = testConfig.getBrowserSize();
        Configuration.browser = testConfig.getBrowserName();
        if (testConfig.isRemote()) {
            Configuration.browserVersion = testConfig.getBrowserVersion();
            Configuration.remote = "https://" + authConfig.getUserLogin() + ":" + authConfig.getUserPassword() + "@"
                    + testConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map .<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
