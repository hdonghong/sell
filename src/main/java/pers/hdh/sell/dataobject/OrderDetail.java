package pers.hdh.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * OrderDetail class<br/>
 * 订单详情
 * @author hdonghong
 * @date 2018/04/04
 */
@Entity
@Data
public class OrderDetail {

    /** 详情主键 */
    @Id
    private String detailId;

    /** 从属的订单主键 */
    private String orderId;

    /** 对应的商品主键 */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品小图 */
    private String productIcon;
}
