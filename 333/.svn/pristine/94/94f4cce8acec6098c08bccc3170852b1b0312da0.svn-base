package com.gcfd.registration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangshengbo
 * @date 2018-03-13
 *
 */
//@EnableFeignClients   // 可用使用feign调用服务
@SpringBootApplication  // spring boot
//@EnableEurekaClient   // 只消费不注册
//@EnableDiscoveryClient // 即消费也注册
@EnableEurekaServer
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources();
    }

}
