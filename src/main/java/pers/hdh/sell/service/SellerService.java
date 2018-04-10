package pers.hdh.sell.service;

import org.springframework.stereotype.Service;
import pers.hdh.sell.dataobject.SellerInfo;

/**
 * SellerService interface<br/>
 * 卖家端信息
 * @author hdonghong
 * @date 2018/04/10
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
