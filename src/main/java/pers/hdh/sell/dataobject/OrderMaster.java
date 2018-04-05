package pers.hdh.sell.dataobject;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import pers.hdh.sell.constants.OrderStatusEnum;
import pers.hdh.sell.constants.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderMaster class<br/>
 * 订单
 * @author hdonghong
 * @date 2018/04/04
 */
@Entity
@Data
@ToString
@DynamicUpdate// 动态更新updateTime属性
public class OrderMaster {

    /** 订单主键 */
    @Id
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openId */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认0新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认0未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

}
