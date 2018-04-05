package pers.hdh.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.hdh.sell.dataobject.OrderDetail;

import java.util.List;

/**
 * OrderDetailRepository interface<br/>
 * 订单详情
 * @author hdonghong
 * @date 2018/04/04
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 通过订单主键关联查询订单详情表
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
