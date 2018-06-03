package com.gcfd;

import com.gcfd.service.ServletFilter;
import com.gcfd.service.SystemInit;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 赵博文
 * @date 2017/4/11 17:57
 */
//@EnableFeignClients   // 可用使用feign调用服务
@SpringBootApplication  // spring boot
@EnableTransactionManagement
//@EnableEurekaClient   // 只消费不注册
@EnableDiscoveryClient // 即消费也注册
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources();
    }

    /**
     * 配置初始化加载事件
     * @author YGX
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<SystemInit> listenerRegistration(){
        ServletListenerRegistrationBean<SystemInit> registration = new ServletListenerRegistrationBean<SystemInit>(new SystemInit());
        return registration;
    }

    /**
     * 配置接口过滤器
     * @author YGX
     * @return
     */
   @Bean
    public FilterRegistrationBean filrerRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean(new ServletFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 配置初始化访问页面
     * @author YGX
     * @return
     */
/*    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

        TomcatContextCustomizer contextCustomizer = new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                // TODO Auto-generated method stub
                context.addWelcomeFile("/index.html");
            }
        };
        factory.addContextCustomizers(contextCustomizer);

        return factory;
    }*/

}
