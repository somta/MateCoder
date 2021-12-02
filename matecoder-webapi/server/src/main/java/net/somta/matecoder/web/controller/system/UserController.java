package net.somta.matecoder.web.controller.system;

import java.util.*;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;
import net.somta.core.exception.BizException;
import net.somta.matecoder.model.system.User;
import net.somta.matecoder.model.system.vo.UserVO;
import net.somta.matecoder.service.system.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @Description: 用户控制类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController{
	
	private final static Logger loger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private IUserService userService;
	
	
	/**
	 * 新增用户
	 * @param user 用户实体
	 */
	@PostMapping("/addUser")
    public ResponseDataResult<User> addUser(@RequestBody User user){
		if(user == null){
			throw new BizException("user_is_null","user is null");
		}
        user.setCreatedAt(new Date());
        return userService.add(user);
    }
    
    /**
	 * 根据ID删除用户
	 * @param id
	 */
	@DeleteMapping("/deleteById/{id}")
    public ResponseDataResult<Boolean> deleteById(@PathVariable(name = "id") String id){
		if(id == null){
			throw new BizException("user_id_null","user id is null");
		}
		userService.deleteById(id);
    	return ResponseDataResult.setResponseResult(true);
    }
    
	/**
	 * 修改用户
	 * @param user 用户实体
	 */
	@PutMapping("/update")
    public ResponseDataResult update(@RequestBody User user){
		if(user == null){
			throw new BizException("user_is_null","user is null");
		}
    	return userService.update(user);
    }
	
	/**
     * 根据ID查询用户信息
     * @param id 用户实体ID
     */
	@GetMapping("/queryById/{id}")
    public ResponseDataResult queryById(@PathVariable(name = "id") String id){
		if(id == null){
			throw new BizException("user_id_null","user id is null");
		}
    	User user = userService.queryById(id);
    	return ResponseDataResult.setResponseResult(user);
    }
	
	/**
	 * 查询用户列表
	 * @param userVO 用户VO实体
	 * @return
	 */
	@PostMapping("/queryByList")
	public ResponsePaginationDataResult queryByList(@RequestBody UserVO userVO){
		return userService.queryByList(userVO.getPageNum(),userVO.getPageSize(),userVO);
	}
}



