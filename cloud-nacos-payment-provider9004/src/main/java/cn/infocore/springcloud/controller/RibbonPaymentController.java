package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 19:42
 * @Description
 */
@RestController
public class RibbonPaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> data = new HashMap<>();

    static {
        data.put(1L,new Payment(1L,"fffsfs"));
        data.put(2L,new Payment(2L,"22242422"));
        data.put(3L,new Payment(3L,"33sfs3"));
    }

    @GetMapping(value = "/fallback/{id}")
    public CommonResult<Payment> getRibbonPayment(@PathVariable("id") Long id) {
        Payment payment = data.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort: " + serverPort,payment);
        return result;
    }
}
