package net.somta.matecoder.service.basic;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.model.basic.Group;
import net.somta.matecoder.core.base.IBaseService;

/**
 * 
 * @Description: 组接口
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public interface IGroupService extends IBaseService {


    /**
     * 新增组
     * @param group
     * @return
     */
    ResponseDataResult addGroup(Group group);

    /**
     * 删除组
     * @param id
     * @return
     */
    ResponseDataResult deleteGroup(Integer id);
}


