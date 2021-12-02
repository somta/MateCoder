package net.somta.matecoder.service.basic.internal;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.model.basic.Group;
import net.somta.matecoder.core.base.BaseServiceImpl;
import net.somta.matecoder.core.base.IBaseMapper;
import net.somta.matecoder.mapper.basic.GroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.somta.matecoder.service.basic.IGroupService;

/**
 * 
 * @Description: 组服务类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl implements IGroupService {
  
    private final static Logger loger = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	@Autowired
    private GroupMapper groupMapper;

	@Override
	public IBaseMapper getMapper() {
		return groupMapper;
	}

	@Override
	public ResponseDataResult addGroup(Group group) {
		// TODO 添加git子组
		//添加git子组

		// TODO 添加Jenkins的文件夹
		//添加Jenkins的文件夹

		groupMapper.add(group);
		return ResponseDataResult.setResponseResult();
	}

	@Override
	public ResponseDataResult deleteGroup(Integer id) {
		// TODO 删除git子组，子组下还有git项目，则不删除该子组
		//添加git子组

		// TODO 删除Jenkins的文件夹
		//添加Jenkins的文件夹
		groupMapper.deleteById(id);
		return ResponseDataResult.setResponseResult();
	}
}
