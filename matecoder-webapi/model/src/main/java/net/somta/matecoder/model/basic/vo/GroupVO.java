package net.somta.matecoder.model.basic.vo;

import net.somta.core.base.vo.PageVO;

/**
 * 
 * @Description: 组查询VO类
 *
 * @Date:        2021-08-30
 * @Author:      明天的地平线
 * @Version:     1.0.0
 */
public class GroupVO extends PageVO {

    private Integer domainId;//   领域ID

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }
}

