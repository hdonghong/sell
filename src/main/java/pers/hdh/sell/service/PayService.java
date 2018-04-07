package pers.hdh.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import pers.hdh.sell.dto.OrderDto;

/**
 * PayService interface<br/>
 * 支付
 * @author hdonghong
 * @date 2018/04/05
 */
public interface PayService {

    /**
     * 发起微信支付
     * @param orderDto
     * @return
     */
    PayResponse create(OrderDto orderDto);

    /**
     * 后台异步通知
     * @param notifyData
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     * @param orderDto
     */
    RefundResponse refund(OrderDto orderDto);
}
