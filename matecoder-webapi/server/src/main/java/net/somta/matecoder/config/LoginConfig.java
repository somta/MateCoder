package net.somta.matecoder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginConfig {

    @Value("${odin.login.type}")
    private String type;

    @Value("${odin.login.ldap.url}")
    private String ldapUrl;

    @Value("${odin.login.ldap.base}")
    private String ldapBase;

    @Value("${odin.login.ldap.username}")
    private String ldapUsername;

    @Value("${odin.login.ldap.password}")
    private String ldapPassword;

    public String getType() {
        return type;
    }

    public String getLdapUrl() {
        return ldapUrl;
    }

    public String getLdapBase() {
        return ldapBase;
    }

    public String getLdapUsername() {
        return ldapUsername;
    }

    public String getLdapPassword() {
        return ldapPassword;
    }
}
