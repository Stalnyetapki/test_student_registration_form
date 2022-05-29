package config;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseurl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserName")
    @DefaultValue("Chrome")
    String getBrowserName();

    @Key("remoteUrl")
    String getRemoteConnection();
}
