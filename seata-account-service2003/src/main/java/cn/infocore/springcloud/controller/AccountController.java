package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.dto.CommonResult;
import cn.infocore.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 11:34
 * @Description
 */
@RestController
public class AccountController {

    @Resource
    private AccountService service;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money) {
        service.decrease(userId, money);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<>(200, "扣减余额成功");
    }
}
