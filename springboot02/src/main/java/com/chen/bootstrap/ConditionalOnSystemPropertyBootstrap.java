package com.chen.bootstrap;

import com.chen.condition.ConditionalOnSystemProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 */
public class ConditionalOnSystemPropertyBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(ConditionalOnSystemPropertyBootstrap.class);

    /**
     * 本系统中的值为 chen
     * @return
     */
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "chen")
    public String helloWorld() {
        return "Hello World chen";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        logger.info("helloWorld Bean: {}", helloWorld);

        // 关闭上下文
        context.close();
    }
}
