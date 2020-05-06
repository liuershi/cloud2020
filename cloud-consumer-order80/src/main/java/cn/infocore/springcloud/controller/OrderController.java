package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.bl.LoadBalance;
import cn.infocore.springcloud.bl.LoadBalanceImpl;
import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 15:46
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_PROVIDER_URL = "http://localhost:8001/cloud-provider-service";
    public static final String PAYMENT_PROVIDER_URL = "http://CLOUD-PROVIDER-SERVICE/cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    LoadBalance loadBalance;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        // 注意，返回的CommonResult必须要有无参构造，否则getForObject()方法会抛出异常
        return restTemplate.getForObject(PAYMENT_PROVIDER_URL + "/payment/get/" + id, CommonResult.class);


        /**
         * 使用getForObject()方法返回对象为响应体中数据转换成的对象，基本上可以理解为json
         */



    }
    // 测试getForEntity方法
    @GetMapping(value = "/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_PROVIDER_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) { // success
            log.info(entity.getStatusCode() + "\t" + entity.getHeaders() + "\t" + entity.getBody());
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "查询失败");
        }

        /**
         * 使用getForEntity()方法返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如说响应头，响应状态码，响应体等
         */



    }

    @GetMapping(value = "/payment/create")
    public CommonResult createPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_PROVIDER_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * 测试自定义负载均衡算法
     * @return
     */
    @GetMapping(value = "/consumer/payment/getBL")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instance = loadBalance.getServiceInstance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/cloud-provider-service/payment/getBL", String.class);
    }
}
