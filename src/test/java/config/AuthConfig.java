package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:authentication.properties"
})
public interface AuthConfig extends Config {

    @Key("userLogin")
    String getUserLogin();

    @Key("userPassword")
    String getUserPassword();
}
