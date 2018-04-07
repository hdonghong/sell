package pers.hdh.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.service.OrderService;
import pers.hdh.sell.service.PayService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate() {
        OrderDto orderDto = orderService.findOne("1522854482315357144");
        payService.create(orderDto);
    }

    @Test
    public void testRefund() {
        OrderDto orderDto = orderService.findOne("1522854482315357144");
        payService.refund(orderDto);
    }
}