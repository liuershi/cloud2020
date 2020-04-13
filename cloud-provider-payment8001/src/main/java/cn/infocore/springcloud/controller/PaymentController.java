package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import cn.infocore.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 14:09
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult result;
        if (payment == null) {
            result = new CommonResult<>(444, "未找到id为" + id + "的对象");
            log.info("未找到id为" + id + "的对象");
        } else {
            result = new CommonResult<Payment>(200, "查询成功", payment);
            log.info("查询成功");
        }
        return result;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int createResult = paymentService.createPayment(payment);
        CommonResult result;
        if (createResult > 0) {
            result = new CommonResult<Integer>(200, "创建成功", createResult);
            log.info("创建对象成功");
        } else {
            result = new CommonResult<>(444, "创建失败", null);
            log.info("创建对象失败");
        }
        return result;
    }
}
