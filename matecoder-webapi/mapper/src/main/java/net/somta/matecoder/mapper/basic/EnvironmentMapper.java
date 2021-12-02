package net.somta.matecoder.mapper.basic;

import net.somta.matecoder.model.basic.Environment;
import net.somta.matecoder.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @Description: 环境数据操作类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Mapper
public interface EnvironmentMapper extends IBaseMapper {


    Environment queryEnvironmentByName(String name);
}




