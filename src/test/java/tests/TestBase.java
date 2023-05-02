package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.AuthConfig;
import config.TestConfig;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @BeforeAll
    @Step("Setting configuration")
    static void BeforeAll() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = testConfig.getBaseurl();
        Configuration.browserSize = testConfig.getBrowserSize();
        Configuration.browser = testConfig.getBrowserName();
        if (testConfig.isRemote()) {
            Configuration.remote = "https://" + authConfig.getUserLogin() + ":" + authConfig.getUserPassword() + "@"
                    + testConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
