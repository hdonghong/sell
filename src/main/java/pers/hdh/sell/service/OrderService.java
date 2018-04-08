package pers.hdh.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.hdh.sell.dto.OrderDto;

/**
 * OrderService interface<br/>
 *
 * @author hdonghong
 * @date 2018/04/04
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    OrderDto findOne(String orderId);

    /**
     * 查询买家订单列表
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

    /**
     * 查询所有订单列表
     * @param pageable
     * @return
     */
    Page<OrderDto> findList(Pageable pageable);

    /**
     * 取消订单
     * @param orderDto
     * @return
     */
    OrderDto cancel(OrderDto orderDto);

    /**
     * 完结订单
     * @param orderDto
     * @return
     */
    OrderDto finish(OrderDto orderDto);

    /**
     * 支付订单
     * @param orderDto
     * @return
     */
    OrderDto paid(OrderDto orderDto);
}
