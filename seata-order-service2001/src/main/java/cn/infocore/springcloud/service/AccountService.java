package cn.infocore.springcloud.service;

import cn.infocore.springcloud.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:46
 * @Description
 */
@Component
@FeignClient(value = "cloud-seata-account")
public interface AccountService {

    /**
     * Deduction of account balance service
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
