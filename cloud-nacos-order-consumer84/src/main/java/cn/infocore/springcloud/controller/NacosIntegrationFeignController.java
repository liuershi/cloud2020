package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import cn.infocore.springcloud.feignservice.FeignService;
import cn.infocore.springcloud.feignservice.impl.FeignServiceImpl;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 20:37
 * @Description
 */
@RestController
public class NacosIntegrationFeignController {

    @Resource
    private FeignService service;

    @GetMapping(value = "/consumer/openfeign/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = service.getFeignPayment(id);
        return result;
    }
}
