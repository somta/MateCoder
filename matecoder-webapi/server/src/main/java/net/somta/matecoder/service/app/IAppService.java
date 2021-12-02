package net.somta.matecoder.service.app;

import net.somta.core.base.result.ResponseDataResult;
import net.somta.matecoder.core.base.IBaseService;
import net.somta.matecoder.model.app.AppGuideVO;

/**
 * 
 * @Description: 应用接口
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public interface IAppService extends IBaseService {

    ResponseDataResult addAppByGuide(AppGuideVO appGuideVO);

    void deleteApp(Integer id);

    boolean isExistApp(String name);

}


