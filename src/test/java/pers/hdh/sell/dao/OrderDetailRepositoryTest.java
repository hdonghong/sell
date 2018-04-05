package pers.hdh.sell.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456777");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xx.jpg");
        orderDetail.setProductId("123458");
        orderDetail.setProductName("芒果冰呀");
        orderDetail.setProductPrice(new BigDecimal(2.4));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0, orderDetailList.size());

    }

}