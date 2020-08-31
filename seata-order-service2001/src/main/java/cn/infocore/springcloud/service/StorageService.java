package cn.infocore.springcloud.service;

import cn.infocore.springcloud.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:42
 * @Description
 */
@Component
@FeignClient(value = "cloud-seata-storage")
public interface StorageService {

    /**
     * Deduction of inventory service
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
