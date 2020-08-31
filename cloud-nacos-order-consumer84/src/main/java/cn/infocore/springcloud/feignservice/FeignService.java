package cn.infocore.springcloud.feignservice;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import cn.infocore.springcloud.feignservice.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 20:35
 * @Description
 */
@FeignClient(value = "cloud-nacos-provider", fallback = FeignServiceImpl.class)
public interface FeignService {

    @GetMapping(value = "/fallback/{id}")
    CommonResult<Payment> getFeignPayment(@PathVariable("id") Long id);
}
