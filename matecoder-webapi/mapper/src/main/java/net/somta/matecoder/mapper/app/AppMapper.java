package net.somta.matecoder.mapper.app;

import net.somta.matecoder.model.app.App;
import net.somta.matecoder.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @Description: 应用数据操作类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Mapper
public interface AppMapper extends IBaseMapper {


    App queryAppByName(String name);
}




