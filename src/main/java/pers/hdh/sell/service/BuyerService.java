package pers.hdh.sell.service;

import pers.hdh.sell.dto.OrderDto;

/**
 * BuyerService interface<br/>
 * 买家
 * @author hdonghong
 * @date 2018/04/05
 */
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto cancelOrder(String openid, String orderId);
}
