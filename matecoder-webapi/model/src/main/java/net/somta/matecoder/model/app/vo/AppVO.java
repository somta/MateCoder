package net.somta.matecoder.model.app.vo;


import net.somta.core.base.vo.PageVO;

/**
 * 
 * @Description: 应用查询VO类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public class AppVO extends PageVO {

	private String envName;

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }
}

