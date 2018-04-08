package pers.hdh.sell.constants;

import lombok.Getter;

/**
 * OrderStatusEnum enum<br/>
 * 订单状态
 * @author hdonghong
 * @date 2018/04/04
 */
@Getter
public enum OrderStatusEnum implements CodeEnum<Integer> {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
