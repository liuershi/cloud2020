package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import cn.infocore.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult result;
        if (payment == null) {
            result = new CommonResult<>(444, "未找到id为" + id + "的对象");
            log.info("未找到id为" + id + "的对象");
        } else {
            result = new CommonResult<Payment>(200, "查询成功,serverPort:" + serverPort, payment);
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

    @GetMapping(value = "/payment/getServiceInstance")
    public Object getServiceInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instanceId:" + instance.getInstanceId() + "\t" + "host:" + instance.getHost() + "\t" + "port:" + instance.getPort() + "\t" + "url:" + instance.getUri());
        }

        List<String> services = discoveryClient.getServices();
        Iterator<String> iterator = services.iterator();
        while (iterator.hasNext()) {
            log.info("service" + iterator.next());
        }
        return services;
    }
}
