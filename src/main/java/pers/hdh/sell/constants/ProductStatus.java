package pers.hdh.sell.constants;

import lombok.Getter;

/**
 * ProductStatus enum<br/>
 * 商品状态
 * @author hdonghong
 * @date 2018/04/03
 */
@Getter
public enum ProductStatus {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
