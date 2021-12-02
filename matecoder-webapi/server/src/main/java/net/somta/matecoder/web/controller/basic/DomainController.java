package net.somta.matecoder.web.controller.basic;


import java.util.*;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.basic.Domain;
import net.somta.matecoder.model.basic.vo.DomainVO;
import net.somta.matecoder.model.basic.vo.GroupVO;
import net.somta.matecoder.service.basic.IDomainService;
import net.somta.matecoder.service.basic.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @Description: 领域控制类
 *
 * @Date:        2021-08-24
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@RestController
@RequestMapping("/v1/domain")
public class DomainController{
	
	private final static Logger loger = LoggerFactory.getLogger(DomainController.class);

	@Autowired
	private IDomainService domainService;
	@Autowired
	private IGroupService groupService;


	/* private final IDomainService domainService;

	 public DomainController(IDomainService domainService) {
		 this.domainService = domainService;
	 }*/

	 /**
	 * 新增领域
	 * @param domain 领域实体
	 */
	@PostMapping("/addDomain")
    public ResponseDataResult addDomain(@RequestBody Domain domain){
       if(domain == null){
		   throw new BizException("domain_is_null","domain is null");
    	}
        domain.setCreatedAt(new Date());
        return domainService.add(domain);
    }
    
    /**
	 * 根据ID删除领域
	 * @param id
	 */
	@DeleteMapping("/deleteById/{id}")
    public ResponseDataResult deleteById(@PathVariable(name = "id") Integer id) throws Exception{
    	if(id == null){
			throw new BizException("domain_is_null","domain is null");
    	}
		GroupVO groupVO = new GroupVO();
		groupVO.setDomainId(id);
    	Long count = groupService.queryListCount(groupVO);
    	if(count > 0){
			throw new BizException("group_is_not_null","该领域下存在组，无法删除");
		}
		domainService.deleteById(id);
    	return ResponseDataResult.setResponseResult();
    }
    
	/**
	 * 修改领域
	 * @param domain 领域实体
	 */
	@PutMapping("/update")
    public ResponseDataResult update(@RequestBody Domain domain) throws Exception{
    	if(domain == null){
			throw new BizException("domain_is_null","domain is null");
    	}
    	return domainService.update(domain);
    }
	
	/**
     * 根据ID查询领域信息
     * @param id 领域实体ID
     */
	@GetMapping("/queryById/{id}")
    public ResponseDataResult queryById(@PathVariable(name = "id") Integer id){
		if(id == null){
			throw new BizException("domain_id_null","domain id is null");
		}
    	Domain domain = domainService.queryById(id);
    	return ResponseDataResult.setResponseResult(domain);
    }
	
	/**
	 * 查询领域列表
	 * @param domainVO 领域VO实体
	 * @return
	 */
	@PostMapping("/queryByList")
	public ResponsePaginationDataResult queryByList(@RequestBody DomainVO domainVO){
		ResponsePaginationDataResult domainList = domainService.queryByList(domainVO.getPageNum(),domainVO.getPageSize(),domainVO);
    	return domainList;
	}
}



