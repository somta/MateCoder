package net.somta.matecoder.web.controller.basic;


import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.basic.Group;
import net.somta.matecoder.model.basic.vo.GroupVO;
import net.somta.matecoder.service.basic.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @Description: 组控制类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@RestController
@RequestMapping("/group")
public class GroupController{
	
	private final static Logger loger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired 
	private IGroupService groupService;
	
	/**
	 * 新增组
	 * @param group 组实体
	 */
	@PostMapping("/addGroup")
    public ResponseDataResult addGroup(@RequestBody Group group){
		if(group == null){
			throw new BizException("group_is_null","group is null");
		}
		return groupService.addGroup(group);
    }
    
    /**
	 * 根据ID删除组
	 * @param id
	 */
	@DeleteMapping("/deleteById/{id}")
    public ResponseDataResult deleteById(@PathVariable(name = "id") Integer id){
		if(id == null){
			throw new BizException("group_is_null","group is null");
		}
		Group group = groupService.queryById(id);
		// todo 检查组下是否还存在应用，先删除应用
		return groupService.deleteGroup(id);
    }
    
	/**
	 * 修改组
	 * @param group 组实体
	 */
	@PutMapping("/update")
    public ResponseDataResult update(@RequestBody Group group){
		if(group == null){
			throw new BizException("group_is_null","group is null");
		}
    	return groupService.update(group);
    }
	
	/**
     * 根据ID查询组信息
     * @param id 组实体ID
     */
	@GetMapping("/queryById/{id}")
    public ResponseDataResult queryById(@PathVariable(name = "id") Integer id){
    	Group group = groupService.queryById(id);
    	return ResponseDataResult.setResponseResult(group);
    }
	
	/**
	 * 查询组列表
	 * @param groupVO 组VO实体
	 * @return
	 */
	@PostMapping("/queryByList")
	public ResponsePaginationDataResult queryByList(@RequestBody GroupVO groupVO){
        return groupService.queryByList(groupVO.getPageNum(),groupVO.getPageSize(),groupVO);
	}
}



