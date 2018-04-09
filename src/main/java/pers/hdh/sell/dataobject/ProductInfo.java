package pers.hdh.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.hdh.sell.constants.CodeEnum;
import pers.hdh.sell.constants.ProductStatusEnum;
import pers.hdh.sell.utils.EnumUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ProductInfo class<br/>
 * 商品
 * @author hdonghong
 * @date 2018/04/03
 */
@Entity
@Data
@DynamicUpdate
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
