package pers.hdh.sell.dataobject.mapper;

import org.apache.ibatis.annotations.*;
import pers.hdh.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Map;

/**
 * ProductCategoryMapper interface<br/>
 *
 * @author hdonghong
 * @date 2018/04/12
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category (category_name, category_type) " +
            "values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category (category_name, category_type) " +
            "values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name like concat('%', #{categoryName}, '%')")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleleByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);
}
