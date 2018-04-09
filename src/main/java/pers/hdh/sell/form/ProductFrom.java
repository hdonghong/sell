package pers.hdh.sell.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProductFrom class<br/>
 *
 * @author hdonghong
 * @date 2018/04/09
 */
@Data
public class ProductFrom {

    /** 商品编号id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;
}
