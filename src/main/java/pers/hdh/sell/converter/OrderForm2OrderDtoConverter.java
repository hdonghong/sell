package pers.hdh.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.dataobject.OrderDetail;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderForm2OrderDtoConverter class<br/>
 *
 * @author hdonghong
 * @date 2018/04/04
 */
@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm) {
        OrderDto orderDto = new OrderDto();

        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【对象转换】 错误，String={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
