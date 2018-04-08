package pers.hdh.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pers.hdh.sell.constants.ResultEnum;
import pers.hdh.sell.converter.OrderForm2OrderDtoConverter;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.form.OrderForm;
import pers.hdh.sell.service.BuyerService;
import pers.hdh.sell.service.OrderService;
import pers.hdh.sell.utils.ResultVoUtil;
import pers.hdh.sell.vo.ResultVo;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BuyerOrderController class<br/>
 *
 * @author hdonghong
 * @date 2018/04/04
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    
    // 创建订单
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            // 确保购物车非空
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDto createResult = orderService.create(orderDto);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVoUtil.success(map);

    }

    // 订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDto>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<OrderDto> orderDtoPage = orderService.findList(openid, request);

        return ResultVoUtil.success(orderDtoPage.getContent());
    }

    // 订单详情
    @GetMapping("/detail")
    public ResultVo<OrderDto> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDto orderDto = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDto);
    }

    // 取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        OrderDto orderDto = buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success(orderDto);
    }    // 取消订单
}
