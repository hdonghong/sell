package pers.hdh.sell.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.ProductCategory;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * ProductCategoryRepositoryTest class<br/>
 *
 * @author hdonghong
 * @date 2018/04/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional// 测试后回滚，不保存数据
    public void testSave() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 3);
        productCategory = repository.save(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    @Transactional// 测试后回滚，不保存数据
    public void testUpdate() {
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryName("男生最爱");
        productCategory  = repository.save(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<ProductCategory> list = repository.findByCategoryTypeIn(Arrays.asList(2, 3));
        Assert.assertNotNull(list);
    }
}