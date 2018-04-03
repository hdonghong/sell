package pers.hdh.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.ProductInfo;
import pers.hdh.sell.service.ProductInfoService;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = service.findOne("123456");
        Assert.assertEquals("123456", result.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> infos = service.findUpAll();
        Assert.assertNotEquals(0, infos.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> page = service.findAll(pageRequest);
        Assert.assertNotNull(null, page);
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("芒果冰");
        productInfo.setProductPrice(new BigDecimal(0.1));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("售芒果冰，轻松月入15k");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);
    }

}