package pers.hdh.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import pers.hdh.sell.constants.OrderStatusEnum;
import pers.hdh.sell.constants.PayStatusEnum;
import pers.hdh.sell.dataobject.OrderDetail;
import pers.hdh.sell.utils.EnumUtil;
import pers.hdh.sell.utils.serializer.Date2LongSerializer;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * OrderDto class<br/>
 * 订单DTO
 * @author hdonghong
 * @date 2018/04/04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)// 不返回值为null的属性
public class OrderDto {

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
    private Integer orderStatus;

    /** 支付状态，默认0未支付 */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 修改时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
