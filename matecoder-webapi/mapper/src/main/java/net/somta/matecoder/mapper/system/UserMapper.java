package net.somta.matecoder.mapper.system;

import net.somta.matecoder.model.system.User;
import net.somta.matecoder.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @Description: 用户数据操作类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Mapper
public interface UserMapper extends IBaseMapper {


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User queryUserByName(String username);
}




