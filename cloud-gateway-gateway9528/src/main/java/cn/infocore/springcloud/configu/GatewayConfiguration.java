package cn.infocore.springcloud.configu;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 14:04
 * @Description 使用编码方式实现gateway路由
 */
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /**
         * 注意：下面代码含义等同于访问 http://localhost:9528/guonei 路由到 http://news.baidu.com/guonei
         */
        routes.route("code_route_one", t -> t.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("code_route_two", t -> t.path("/guoji").uri("http://news.baidu.com/guoji"));
        routes.route("code_route_three", t -> t.path("/mil").uri("http://news.baidu.com/mil"));
        routes.route("code_route_four", t -> t.path("/finance").uri("http://news.baidu.com/finance"));
        routes.route("code_route_five", t -> t.path("/ent").uri("http://news.baidu.com/ent"));
        routes.route("code_route_six", t -> t.path("/sports").uri("http://news.baidu.com/sports"));
        routes.route("code_route_seven", t -> t.path("/internet").uri("http://news.baidu.com/internet"));
        routes.route("code_route_eight", t -> t.path("/tech").uri("http://news.baidu.com/tech"));
        routes.route("code_route_nine", t -> t.path("/game").uri("http://news.baidu.com/game"));
        routes.route("code_route_ten", t -> t.path("/lady").uri("http://news.baidu.com/lady"));
        routes.route("code_route_zero", t -> t.path("/auto").uri("http://news.baidu.com/auto"));
        return routes.build();
    }
}
