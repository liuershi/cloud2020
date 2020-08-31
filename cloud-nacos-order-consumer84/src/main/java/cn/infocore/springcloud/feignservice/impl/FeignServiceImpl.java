package cn.infocore.springcloud.feignservice.impl;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import cn.infocore.springcloud.feignservice.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 20:36
 * @Description
 */
@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public CommonResult<Payment> getFeignPayment(Long id) {
        return new CommonResult<>(445, "调用feign接口失败，进入降级方法", new Payment(id, null));
    }
}
