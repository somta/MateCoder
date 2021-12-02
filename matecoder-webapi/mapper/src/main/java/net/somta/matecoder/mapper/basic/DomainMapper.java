package net.somta.matecoder.mapper.basic;

import net.somta.matecoder.model.basic.Domain;
import net.somta.matecoder.core.base.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @Description: 领域数据操作类
 *
 * @Date:        2021-08-24
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Mapper
public interface DomainMapper extends IBaseMapper {


    Domain add(Domain t);
	
}




