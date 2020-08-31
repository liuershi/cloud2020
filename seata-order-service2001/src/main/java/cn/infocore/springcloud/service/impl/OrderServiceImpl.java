package cn.infocore.springcloud.service.impl;

import cn.infocore.springcloud.dao.OrderDao;
import cn.infocore.springcloud.dto.CommonResult;
import cn.infocore.springcloud.dto.Order;
import cn.infocore.springcloud.service.AccountService;
import cn.infocore.springcloud.service.OrderService;
import cn.infocore.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executors;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:39
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "global-create-order", rollbackFor = Exception.class)
    public CommonResult create(Order order) {
        log.info("start create new order");
        orderDao.create(order);

        log.info("Start deduction of inventory");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("End deduction of inventory");

        log.info("Start deduction of account balance");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("End deduction of account balance");

        orderDao.update(order.getUserId(), 0);
        log.info("create order end");

        return new CommonResult(200, "create order successful");
    }
}
