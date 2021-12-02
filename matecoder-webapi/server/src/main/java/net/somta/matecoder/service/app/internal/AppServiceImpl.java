package net.somta.matecoder.service.app.internal;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.model.app.App;
import net.somta.matecoder.service.app.IAppService;
import net.somta.matecoder.core.base.BaseServiceImpl;
import net.somta.matecoder.core.base.IBaseMapper;
import net.somta.matecoder.mapper.app.AppMapper;
import net.somta.matecoder.model.app.AppGuideVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 
 * @Description: 应用服务类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@Service
public class AppServiceImpl extends BaseServiceImpl implements IAppService {
  
    private final static Logger loger = LoggerFactory.getLogger(AppServiceImpl.class);
	
	@Autowired
    private AppMapper appMapper;

	@Override
	public IBaseMapper getMapper() {
		return appMapper;
	}

	@Override
	public ResponseDataResult addAppByGuide(AppGuideVO appGuideVO) {
		// todo 待完善
		// 新增数据库

		// 生成代码模板

		// 上传代码到git仓库

		//创建jenkins项目

		//创建k8s部署

		return null;
	}

	@Override
	public void deleteApp(Integer id) {
		// todo 待完善
		// 删除k8s部署

		// 删除jenkins项目

		// 删除数据库数据
	}

	@Override
	public boolean isExistApp(String name) {
		App app = appMapper.queryAppByName(name);
		if(app != null){
			return true;
		}
		return false;
	}
}
