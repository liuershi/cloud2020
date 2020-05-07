package cn.infocore.springcloud.service;

import cn.infocore.springcloud.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/7 9:05
 * @Description
 */
@Component//将业务接口扫描进容器
@FeignClient(value = "CLOUD-PROVIDER-SERVICE" + "/cloud-provider-service")//value值为微服务中服务提供者的url
public interface PaymentOpenfeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
