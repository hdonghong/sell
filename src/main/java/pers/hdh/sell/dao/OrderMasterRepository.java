package pers.hdh.sell.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pers.hdh.sell.dataobject.OrderMaster;

/**
 * OrderMasterRepository interface<br/>
 * 订单
 * @author hdonghong
 * @date 2018/04/04
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 分页条件和买家主键查询订单表
     * @param buyerOpenid 买家主键
     * @param pageable 分页条件
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
