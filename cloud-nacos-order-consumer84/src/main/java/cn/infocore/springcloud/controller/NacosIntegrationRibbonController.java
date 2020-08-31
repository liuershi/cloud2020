package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 19:32
 * @Description
 */
@RestController
public class NacosIntegrationRibbonController {

    private static final String PROVIDER_SERVER_URL = "http://cloud-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(fallback = "ribbon_fallback", value = "fallback", blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult commonResult = restTemplate.getForObject(PROVIDER_SERVER_URL + "/fallback/" + id, CommonResult.class);

        if (id == 4L) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (commonResult.getResult() == null) {
            throw new NullPointerException("空指针异常，不存在此参数");
        }
        return commonResult;
    }
    public CommonResult<Payment> ribbon_fallback(@PathVariable("id") Long id, Throwable t) {
        return new CommonResult<>(444, "id:" + id + "消费失败，exception:" + t.getMessage(), new Payment(id, null));
    }
    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }
}
