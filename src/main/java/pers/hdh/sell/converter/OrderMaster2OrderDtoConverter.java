package pers.hdh.sell.converter;

import org.springframework.beans.BeanUtils;
import pers.hdh.sell.dataobject.OrderMaster;
import pers.hdh.sell.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster2OrderDtoConverter class<br/>
 *
 * @author hdonghong
 * @date 2018/04/04
 */
public class OrderMaster2OrderDtoConverter {

    public static OrderDto convert(OrderMaster orderMaster) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);
        return orderDto;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList
                .stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
