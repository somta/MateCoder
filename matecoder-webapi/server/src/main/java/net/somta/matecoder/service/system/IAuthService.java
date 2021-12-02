package net.somta.matecoder.service.system;

/**
 *
 * @Description: 认证接口
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public interface IAuthService {

    /**
     * ldap认证
     * @param username
     * @param password
     * @return
     */
    Boolean ldapAuth(String username,String password);
}
