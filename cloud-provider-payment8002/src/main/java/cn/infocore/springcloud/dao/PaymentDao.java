package cn.infocore.springcloud.dao;

import cn.infocore.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 13:57
 * @Description
 */
@Mapper
public interface PaymentDao {

    public int createPayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
