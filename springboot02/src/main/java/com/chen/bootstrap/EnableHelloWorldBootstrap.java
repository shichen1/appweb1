package com.chen.bootstrap;

import com.chen.annotation.EnableHelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableHelloWorld} 引导类
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    private static Logger logger = LoggerFactory.getLogger(RepositoryBootstrap.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);

        logger.info("helloWorld Bean: {}", helloWorld);

        // 关闭上下文
        context.close();
    }
}
