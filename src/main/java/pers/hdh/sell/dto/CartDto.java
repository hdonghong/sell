package pers.hdh.sell.dto;

import lombok.Data;
import lombok.ToString;

/**
 * CartDto class<br/>
 * 购物车
 * @author hdonghong
 * @date 2018/04/04
 */
@Data
@ToString
public class CartDto {

    /** 商品id */
    private String productId;

    /** 数量 */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
