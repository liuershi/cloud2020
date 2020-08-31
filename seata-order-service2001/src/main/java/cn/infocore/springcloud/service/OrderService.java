package cn.infocore.springcloud.service;

import cn.infocore.springcloud.dto.CommonResult;
import cn.infocore.springcloud.dto.Order;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:38
 * @Description
 */
public interface OrderService {
    /**
     * create new order
     * @param order
     * @return
     */
    CommonResult create(Order order);
}
