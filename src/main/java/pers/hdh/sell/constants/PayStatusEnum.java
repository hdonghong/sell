package pers.hdh.sell.constants;

import lombok.Getter;

/**
 * PayStatusEnum enum<br/>
 * 支付状态
 * @author hdonghong
 * @date 2018/04/04
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
