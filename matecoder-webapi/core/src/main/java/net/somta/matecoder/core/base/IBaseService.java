package net.somta.matecoder.core.base;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.core.base.result.ResponsePaginationDataResult;

public interface IBaseService {
    public abstract IBaseMapper getMapper();

    /**
     * 新增
     * @param t 实体参数
     * @param <T> 实体
     * @return 返回结果
     * @throws Exception 异常
     */
    <T> ResponseDataResult add(T t);

    /**
     * 根据ID删除
     * @param id 删除ID
     * @return 返回结果
     * @throws Exception 异常
     */
    ResponseDataResult deleteById(Object id);

    /**
     * 修改
     * @param t 入参
     * @param <T> 实体
     * @return 返回结果
     * @throws Exception 异常
     */
    <T> ResponseDataResult update(T t);

    /**
     * 根据Id查询
     * @param id 查询ID
     * @param <T> 实体
     * @return 返回结果
     * @throws Exception 异常
     */
    <T> T queryById(Object id);

    /**
     * 查询列表总数
     * @param param
     * @return
     */
    Long queryListCount(Object param);

    /**
     * 查询列表
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @param param 查询参数
     * @param <T> 实体
     * @return 返回结果列表
     * @throws Exception 异常
     */
    <T> ResponsePaginationDataResult queryByList(Integer pageNum, Integer pageSize, Object param);

}
