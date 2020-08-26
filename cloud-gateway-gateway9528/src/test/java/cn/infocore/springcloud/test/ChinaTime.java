package cn.infocore.springcloud.test;

import java.time.ZonedDateTime;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 14:35
 * @Description
 */
public class ChinaTime {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
