package net.somta.matecoder.service.basic;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.model.basic.Environment;
import net.somta.matecoder.core.base.IBaseService;

/**
 * 
 * @Description: 环境接口
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public interface IEnvironmentService extends IBaseService {


    ResponseDataResult addEnvironment(Environment environment);

    void deleteEnvironment(Integer id, String name);

    boolean isExistEnvironment(String name);
}


