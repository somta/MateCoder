package net.somta.matecoder.configuration;

import net.somta.matecoder.config.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import java.util.HashMap;
import java.util.Map;

/**
 * LDAP 的自动配置类
 *
 * 完成连接 及LdapTemplate生成
 */
@Configuration
public class LdapConfiguration {

    @Autowired
    private LoginConfig loginConfig;

    private LdapTemplate ldapTemplate;

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        Map<String, Object> config = new HashMap();

        contextSource.setUrl(loginConfig.getLdapUrl());
        contextSource.setBase(loginConfig.getLdapBase());
        contextSource.setUserDn(loginConfig.getLdapUsername());
        contextSource.setPassword(loginConfig.getLdapPassword());

        //  解决乱码
        config.put("java.naming.ldap.attributes.binary", "objectGUID");

        contextSource.setPooled(true);
        contextSource.setBaseEnvironmentProperties(config);
        return contextSource;
    }
 
    @Bean
    public LdapTemplate ldapTemplate() {
        if (null == ldapTemplate){
            ldapTemplate = new LdapTemplate(contextSource());
        }
        return ldapTemplate;
    }

}