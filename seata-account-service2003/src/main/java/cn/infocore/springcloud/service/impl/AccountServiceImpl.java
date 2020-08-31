package cn.infocore.springcloud.service.impl;

import cn.infocore.springcloud.dao.AccountDao;
import cn.infocore.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 11:29
 * @Description
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }
}
