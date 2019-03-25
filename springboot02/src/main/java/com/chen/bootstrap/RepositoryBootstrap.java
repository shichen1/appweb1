package com.chen.bootstrap;

import com.chen.repository.MyFirstLevelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 */
@ComponentScan(basePackages = "com.chen.repository")
public class RepositoryBootstrap {

    private static Logger logger = LoggerFactory.getLogger(RepositoryBootstrap.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        logger.info("myFirstLevelRepository Bean: {}", myFirstLevelRepository);

        // 关闭上下文
        context.close();
    }

}
