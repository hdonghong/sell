package pers.hdh.sell.service;

import pers.hdh.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * ProductCategoryService interface<br/>
 * 类目
 * @author hdonghong
 * @date 2018/04/03
 */
public interface ProductCategoryService {

    /**
     * 通过类目主键查询类目
     * @param categoryId 类目主键
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     * @return 类目列表
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目编号列表查询类目
     * @param categoryTypeList 类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存/更新类目信息
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
