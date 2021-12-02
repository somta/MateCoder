package net.somta.matecoder.service.basic.internal;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.model.basic.Environment;
import net.somta.matecoder.core.base.BaseServiceImpl;
import net.somta.matecoder.core.base.IBaseMapper;
import net.somta.matecoder.mapper.basic.EnvironmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.somta.matecoder.service.basic.IEnvironmentService;

import java.util.Date;

/**
 * 
 * @Description: 环境服务类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Service
public class EnvironmentServiceImpl extends BaseServiceImpl implements IEnvironmentService {
  
    private final static Logger loger = LoggerFactory.getLogger(EnvironmentServiceImpl.class);
	
	@Autowired
    private EnvironmentMapper environmentMapper;

	@Override
	public IBaseMapper getMapper() {
		return environmentMapper;
	}

	@Override
	public ResponseDataResult addEnvironment(Environment environment) {

		// todo jenkins 新建一个试图

		environment.setCreatedAt(new Date());
		environmentMapper.add(environment);
		return ResponseDataResult.setResponseResult();
	}

	@Override
	public void deleteEnvironment(Integer id, String name) {
        // todo 删除jenkins 试图
		environmentMapper.deleteById(id);
	}

	@Override
	public boolean isExistEnvironment(String name) {
		Environment environment = environmentMapper.queryEnvironmentByName(name);
		if(environment != null){
			return true;
		}
		return false;
	}
}
