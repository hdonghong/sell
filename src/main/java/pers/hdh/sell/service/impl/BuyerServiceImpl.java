package pers.hdh.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.service.BuyerService;
import pers.hdh.sell.service.OrderService;

/**
 * BuyerServiceImpl class<br/>
 *
 * @author hdonghong
 * @date 2018/04/05
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        if (orderDto == null) {
            log.error("【取消订单】 查询不到此订单，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderOwner(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null) {
            return null;
        }
        // 判断是否是自己的订单
        if (!orderDto.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】 订单的openid不一致，openid={}，orderId={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
