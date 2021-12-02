package net.somta.matecoder.service.system.internal;

import net.somta.matecoder.model.system.User;
import net.somta.matecoder.core.base.BaseServiceImpl;
import net.somta.matecoder.core.base.IBaseMapper;
import net.somta.matecoder.mapper.system.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.somta.matecoder.service.system.IUserService;

/**
 * 
 * @Description: 用户服务类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
  
    private final static Logger loger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserMapper userMapper;

	@Override
	public IBaseMapper getMapper() {
		return userMapper;
	}


	@Override
	public User queryUserByName(String username) {
		return userMapper.queryUserByName(username);
	}
}
