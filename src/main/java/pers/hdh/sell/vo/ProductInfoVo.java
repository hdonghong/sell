package pers.hdh.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ProductInfoVo class<br/>
 * 商品详情
 * @author hdonghong
 * @date 2018/04/03
 */
@Data
public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -2122857956139661337L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
