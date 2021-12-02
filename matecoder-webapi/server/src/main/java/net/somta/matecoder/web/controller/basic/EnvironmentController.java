package net.somta.matecoder.web.controller.basic;


import java.util.*;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.app.vo.AppVO;
import net.somta.matecoder.model.basic.Environment;
import net.somta.matecoder.model.basic.vo.EnvironmentVO;
import net.somta.matecoder.service.app.IAppService;
import net.somta.matecoder.service.basic.IEnvironmentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @Description: 环境控制类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@RestController
@RequestMapping("/environment")
public class EnvironmentController{
	
	private final static Logger loger = LoggerFactory.getLogger(EnvironmentController.class);
	
	@Autowired 
	private IEnvironmentService environmentService;
	@Autowired
	private IAppService appService;
	
	
	/**
	 * 新增环境
	 * @param environment 环境实体
	 */
	@PostMapping("/addEnvironment")
    public ResponseDataResult addEnvironment(@RequestBody Environment environment){
		if(environment == null){
			throw new BizException("environment_is_null","environment is null");
		}
		if (environmentService.isExistEnvironment(environment.getName())){
			throw new BizException("environment_is_exist","该环境名称已存在");
		}
		return environmentService.addEnvironment(environment);
    }
    
    /**
	 * 根据ID删除环境
	 * @param id
	 */
	@DeleteMapping("/deleteById/{id}/{name}")
    public ResponseDataResult deleteById(@PathVariable(name = "id") Integer id,@PathVariable(name = "name") String name){
		if(id == null){
			throw new BizException("environment_id_null","environment id is null");
		}
		if(StringUtils.isEmpty(name)){
			throw new BizException("environment_id_null","环境名称不能为空");
		}
		AppVO appVO = new AppVO();
		appVO.setEnvName(name);
		Long count = appService.queryListCount(appVO);
		if(count > 0){
			throw new BizException("environment_id_null","该环境下还存在项目无法删除");
		}
		environmentService.deleteEnvironment(id,name);
    	return ResponseDataResult.setResponseResult();
    }
    
	/**
	 * 修改环境
	 * @param environment 环境实体
	 */
	@PutMapping("/update")
    public ResponseDataResult update(@RequestBody Environment environment){
		if(environment == null){
			throw new BizException("environment_is_null","environment is null");
		}
		environment.setUpdatedAt(new Date());
    	return environmentService.update(environment);
    }
	
	/**
     * 根据ID查询环境信息
     * @param id 环境实体ID
     */
	@GetMapping("/queryById/{id}")
    public ResponseDataResult queryById(@PathVariable(name = "id") Integer id){
		if(id == null){
			throw new BizException("environment_id_null","environment id is null");
		}
    	Environment environment = environmentService.queryById(id);
    	return ResponseDataResult.setResponseResult(environment);
    }
	
	/**
	 * 查询环境列表
	 * @param environmentVO 环境VO实体
	 * @return
	 */
	@PostMapping("/queryByList")
	public ResponsePaginationDataResult queryByList(@RequestBody EnvironmentVO environmentVO){
    	return environmentService.queryByList(environmentVO.getPageNum(),environmentVO.getPageSize(),environmentVO);
	}
}



