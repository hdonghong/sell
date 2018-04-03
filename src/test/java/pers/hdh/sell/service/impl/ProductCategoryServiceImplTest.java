package pers.hdh.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.ProductCategory;
import pers.hdh.sell.service.ProductCategoryService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory category = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> categoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryType() throws Exception {
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3));
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory category = productCategoryService.save(
                new ProductCategory("男生专享", 3));
        Assert.assertNotEquals(null, category);
    }

}