package pers.hdh.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.sell.dao.SellerInfoRepository;
import pers.hdh.sell.dataobject.SellerInfo;
import pers.hdh.sell.service.SellerService;

/**
 * SellerServiceImpl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/10
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
