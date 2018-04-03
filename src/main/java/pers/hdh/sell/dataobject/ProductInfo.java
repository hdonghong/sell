package pers.hdh.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ProductInfo class<br/>
 * 商品
 * @author hdonghong
 * @date 2018/04/03
 */
@Entity
@Data
public class ProductInfo {

    /** 商品编号id */
    @Id
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

    /** 状态，0正常1下架 */
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;
}
