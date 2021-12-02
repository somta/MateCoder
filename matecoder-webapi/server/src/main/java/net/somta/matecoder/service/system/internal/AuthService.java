package net.somta.matecoder.service.system.internal;

import net.somta.core.exception.BizException;
import net.somta.matecoder.service.system.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 *
 * @Description: 认证服务类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 * https://www.cnblogs.com/wwjj4811/p/14744639.html
 * https://blog.csdn.net/huonan_123/article/details/95946472
 * https://jishuin.proginn.com/p/763bfbd5da13
 * https://www.jianshu.com/p/3aeb49a9befd
 */
@Service
public class AuthService implements IAuthService {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public Boolean ldapAuth(String username, String password) {
        try {
            /*Person person = ldapTemplate.findOne(LdapQueryBuilder.query().where("uid").is("test1"), Person.class);
            System.out.println(person);*/
            ldapTemplate.authenticate(query().where("uid").is(username), password);
            return true;
        }catch (EmptyResultDataAccessException e){
            throw new BizException("user.isnot.exit","该用户不存在");
        }catch (AuthenticationException e){
            throw new BizException("user.pwd.error","用户密码错误");
        }catch (Exception e){
            throw new BizException("user.auth.error","登录认证异常");
        }
    }
}
