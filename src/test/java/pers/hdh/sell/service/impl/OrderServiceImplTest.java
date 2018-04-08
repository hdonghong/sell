package pers.hdh.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.constants.OrderStatusEnum;
import pers.hdh.sell.constants.PayStatusEnum;
import pers.hdh.sell.dataobject.OrderDetail;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private static final String BUYER_OPENID = "110110";
    private static final String ORDER_ID = "1522833315401578555";

    @Test
    public void create() throws Exception {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail detail1 = new OrderDetail();
        OrderDetail detail2 = new OrderDetail();
        detail1.setProductId("123457");
        detail1.setProductQuantity(10);
        detail2.setProductId("123458");
        detail2.setProductQuantity(1);
        orderDetailList.add(detail1);
        orderDetailList.add(detail2);

        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("hdonghong");
        orderDto.setBuyerAddress("http://github.com/hdonghong");
        orderDto.setBuyerOpenid(BUYER_OPENID);
        orderDto.setBuyerPhone("13456789123");
        orderDto.setOrderDetailList(orderDetailList);

        OrderDto result = orderService.create(orderDto);
        log.info("【创建订单 result={}】", result);
        Assert.assertEquals(result, orderDto);
    }

    @Test
    public void findOne() throws Exception {
        OrderDto result = orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDto> orderDtoPage = orderService.findList(BUYER_OPENID, request);
        log.info("【Test：查询用户的订单列表】 orderDtoPage={}", orderDtoPage);
        assertEquals(0, orderDtoPage.getNumber());
    }

    @Test
    public void testFindList() {
        Page<OrderDto> orderDtoPage = orderService.findList(new PageRequest(0, 2));
        log.info("【Test：查询所有订单列表】orderDtoPage={}", orderDtoPage);
        Assert.assertEquals(0, orderDtoPage.getNumber());
        Assert.assertTrue("查询所有订单列表", orderDtoPage.getTotalElements() > 0);
    }


    @Test
    public void cancel() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.cancel(orderDto);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.finish(orderDto);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.paid(orderDto);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}