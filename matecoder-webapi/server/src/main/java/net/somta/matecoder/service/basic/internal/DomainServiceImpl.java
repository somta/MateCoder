package net.somta.matecoder.service.basic.internal;

import net.somta.matecoder.core.base.BaseServiceImpl;
import net.somta.matecoder.core.base.IBaseMapper;
import net.somta.matecoder.mapper.basic.DomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.somta.matecoder.service.basic.IDomainService;

/**
 * 
 * @Description: 领域服务类
 *
 * @Date:        2021-08-24
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Service
public class DomainServiceImpl extends BaseServiceImpl implements IDomainService {
  
    private final static Logger loger = LoggerFactory.getLogger(DomainServiceImpl.class);
	
	@Autowired
    private DomainMapper domainMapper;

	@Override
	public IBaseMapper getMapper() {
		return domainMapper;
	}
	
}
