package pers.hdh.sell.service;

import pers.hdh.sell.dto.OrderDto;

/**
 * PushMessageService interface<br/>
 * 消息推送
 * @author hdonghong
 * @date 2018/04/11
 */
public interface PushMessageService {

    void orderStatus(OrderDto orderDto);
}
