package pers.hdh.sell.dataobject.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.ProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "测试");
        map.put("categoryType", "101");
        int result = categoryMapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试ByObject");
        productCategory.setCategoryType(102);
        int result = categoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = categoryMapper.findByCategoryType(101);
        Assert.assertEquals(101, result.getCategoryType().intValue());
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> categoryList = categoryMapper.findByCategoryName("测试");
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = categoryMapper.updateByCategoryType("测试更新", 101);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试更新ByObject");
        productCategory.setCategoryType(102);
        int result = categoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleleByCategoryType() {
        int result = categoryMapper.deleleByCategoryType(102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = categoryMapper.selectByCategoryType(101);
        Assert.assertEquals(101, productCategory.getCategoryType().intValue());
    }

}