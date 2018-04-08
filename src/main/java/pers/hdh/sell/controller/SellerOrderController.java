package pers.hdh.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.service.OrderService;

import java.util.Map;

/**
 * SellerOrderController class<br/>
 * 卖家端订单
 * @author hdonghong
 * @date 2018/04/08
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page 第几页，从第1页开始
     * @param size 一页多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "1") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDto> orderDtoPage = orderService.findList(pageRequest);
        map.put("orderDtoPage", orderDtoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        map.put("url", "/sell/seller/order/list");
        try {
            OrderDto orderDto = orderService.findOne(orderId);
            orderService.cancel(orderDto);
            map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
            return new ModelAndView("common/success", map);

        } catch(SellException e) {
            log.error("【卖家端取消订单】 查询不到订单，{}", e);
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }

    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderDto orderDto = orderService.findOne(orderId);
            map.put("orderDto", orderDto);
            return new ModelAndView("order/detail", map);

        } catch (SellException e) {
            log.error("【卖家查看订单详情】 发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
    }


    /**
     * 完结订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        map.put("url", "/sell/seller/order/list");
        try {
            OrderDto orderDto = orderService.findOne(orderId);
            orderService.finish(orderDto);
            map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
            return new ModelAndView("common/success", map);

        } catch (SellException e) {
            log.error("【卖家端完结订单】 发生异常，e={}", e);
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
    }
}
