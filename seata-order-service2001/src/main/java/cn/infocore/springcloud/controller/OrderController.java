package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.dto.CommonResult;
import cn.infocore.springcloud.dto.Order;
import cn.infocore.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:59
 * @Description
 */
@RestController
public class OrderController {

    @Resource
    private OrderService service;

    @GetMapping(value = "/order/create")
    public CommonResult createOrder(Order order) {
        return service.create(order);
    }
}
