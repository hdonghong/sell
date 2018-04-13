package pers.hdh.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ProductVo class<br/>
 * 商品（包含类目）
 * @author hdonghong
 * @date 2018/04/03
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 6817557808487197330L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

}
