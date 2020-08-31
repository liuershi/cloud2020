package cn.infocore.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 11:29
 * @Description
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
