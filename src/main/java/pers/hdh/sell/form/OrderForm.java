package pers.hdh.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * OrderForm class<br/>
 * Controller层 订单的表单验证类
 * @author hdonghong
 * @date 2018/04/04
 */
@Data
public class OrderForm {

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家手机号 */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 地址必填 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家微信openId */
    @NotEmpty(message = "openid必填")
    private String openid;

    /** 购物车 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
