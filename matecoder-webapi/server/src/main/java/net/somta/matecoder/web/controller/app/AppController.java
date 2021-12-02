package net.somta.matecoder.web.controller.app;


import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.Permission;
import net.somta.matecoder.model.app.App;
import net.somta.matecoder.model.app.AppGuideVO;
import net.somta.matecoder.model.app.vo.AppVO;
import net.somta.matecoder.service.app.IAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

 /**
 * 
 * @Description: 应用控制类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@RestController
public class AppController{
	
	private final static Logger loger = LoggerFactory.getLogger(AppController.class);
	
	@Autowired 
	private IAppService appService;
	
	
	/**
	 * 根据创建引导创建应用
	 * @param appGuideVO 应用实体
	 */
	@PostMapping("/v1/app/addAppByGuide")
    public ResponseDataResult addAppByGuide(@RequestBody AppGuideVO appGuideVO){
		if(appGuideVO == null){
			throw new BizException("app_is_null","参数不能为空");
		}
		if (appService.isExistApp(appGuideVO.getName())){
			throw new BizException("app_is_null","该应用已存在");
		}
		return appService.addAppByGuide(appGuideVO);
    }
    
    /**
	 * 根据ID删除应用
	 * @param id
	 */
	@DeleteMapping("/v1/app/deleteById/{id}")
	@Permission(module = "App",key = "/app/deleteById",description = "删除应用")
    public ResponseDataResult deleteById(@PathVariable(name = "id") Integer id){
    	if(id == null){
			throw new BizException("appid_is_null","id不能为空");
    	}
		appService.deleteApp(id);
    	return ResponseDataResult.setResponseResult();
    }
    
	/**
	 * 修改应用
	 * @param app 应用实体
	 */
	@PutMapping("/v1/app/update")
    public ResponseDataResult update(@RequestBody App app){
    	if(app == null){
			throw new BizException("app_is_null","app不能为空");
    	}
    	return appService.update(app);
    }
	
	/**
     * 根据ID查询应用信息
     * @param id 应用实体ID
     */
	@GetMapping("/v1/app/queryById/{id}")
    public ResponseDataResult queryById(@PathVariable(name = "id") String id){
    	App app = appService.queryById(id);
    	return ResponseDataResult.setResponseResult(app);
    }
	
	/**
	 * 查询应用列表
	 * @param appVO 应用VO实体
	 * @return
	 */
	@PostMapping("/v1/app/queryByList")
	public ResponsePaginationDataResult queryByList(@RequestBody AppVO appVO){
		ResponsePaginationDataResult appList = appService.queryByList(appVO.getPageNum(),appVO.getPageSize(),appVO);
    	return appList;
	}
}



