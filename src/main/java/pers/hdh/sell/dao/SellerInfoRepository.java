package pers.hdh.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.hdh.sell.dataobject.SellerInfo;

/**
 * SellerInfoRepository interface<br/>
 * 卖家信息
 * @author hdonghong
 * @date 2018/04/10
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
