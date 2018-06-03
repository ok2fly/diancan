package com.gcfd;

import com.gcfd.common.util.SpringUtil;
import com.gcfd.consumer.ServletFilter;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@EnableFeignClients   // 可用使用feign调用服务
@SpringBootApplication  // spring boot
//@EnableEurekaClient   // 只消费不注册
@EnableDiscoveryClient // 即消费也注册
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources();
    }

    /**
     * @description 配置接口过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean(new ServletFilter());
     //   registration.addUrlPatterns("/api/*");
        return registration;
    }

    /**
     * @description 截取客户端请求头部配置在请求里
     * @return
     */
    @Bean
    public RequestInterceptor headerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String values = request.getHeader(name);
                        requestTemplate.header(name, values);
                    }
                }
            }
        };
    }


    /**
     * @description 设置Feign请求时间,防止多次请求
     * @param env
     * @return
     */
    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 1000000000);
        int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 500000000);
        return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
    }

    /**
     * @description 在spring里注册SpringUtil
     * @return
     */
    @Bean
    public SpringUtil springUtil(){return new SpringUtil();}
}
