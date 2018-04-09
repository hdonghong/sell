package pers.hdh.sell.form;

import lombok.Data;

/**
 * CategoryForm class<br/>
 * 类目表单验证
 * @author hdonghong
 * @date 2018/04/09
 */
@Data
public class CategoryForm {

    /** 类目id */
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;
}
