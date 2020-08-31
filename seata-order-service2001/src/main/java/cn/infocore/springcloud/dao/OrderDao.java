package cn.infocore.springcloud.dao;

import cn.infocore.springcloud.dto.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:37
 * @Description
 */
@Mapper
public interface OrderDao {
    /**
     * create new order
     * @param order
     * @return
     */
    Integer create(Order order);

    /**
     * update order status to 1 from id and status
     * @param id
     * @param status
     * @return
     */
    Integer update(@Param("id") Long id, @Param("status") Integer status);
}
