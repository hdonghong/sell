package pers.hdh.sell.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;
    private static final String OPENID = "abc123";

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("hdonghong");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("http://github.com/hdonghong");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByBuyerOpenid() {
        PageRequest request = new PageRequest(0, 1);
        Page<OrderMaster> page = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, page.getTotalElements());
    }

}