package net.somta.matecoder.service.system;

import net.somta.matecoder.model.system.User;
import net.somta.matecoder.core.base.IBaseService;

/**
 * 
 * @Description: 用户接口
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public interface IUserService extends IBaseService {


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User queryUserByName(String username);
}


