package net.somta.matecoder.web.controller;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.Guest;
import net.somta.matecoder.model.portal.LoginBO;
import net.somta.matecoder.model.portal.LoginVO;
import net.somta.matecoder.model.system.User;
import net.somta.matecoder.service.system.IAuthService;
import net.somta.matecoder.service.system.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class LoginController {

    @Autowired
    private IAuthService authService;
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @Guest()
    public ResponseDataResult<LoginBO> login(@RequestBody LoginVO loginVO){
        if(loginVO == null){
            throw new BizException("user_id_null","登录参数不能为空");
        }
        if(StringUtils.isEmpty(loginVO.getUsername())){
            throw new BizException("username_id_null","用户名不能为空");
        }
        if(StringUtils.isEmpty(loginVO.getPassword())){
            throw new BizException("password_id_null","密码不能为空");
        }
        // todo 根据登录类型判断认证信息
        authService.ldapAuth(loginVO.getUsername(),loginVO.getPassword());
        User user = userService.queryUserByName(loginVO.getUsername());
        if(user == null){
            throw new BizException("userinfo_is_null","用户信息未完善");
        }

        LoginBO loginBO = new LoginBO();
        loginBO.setUsername(loginVO.getUsername());
        loginBO.setToken("123456789");
        return ResponseDataResult.setResponseResult(loginBO);
    }

}
