package pers.hdh.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.hdh.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * ProductCategoryRepository class<br/>
 *
 * @author hdonghong
 * @date 2018/04/03
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 通过类目编号列表查询对应的类目，要求List中的数据不重复
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
