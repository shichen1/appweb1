package com.chen.bootstrap;

import com.chen.service.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService}
 */
@SpringBootApplication(scanBasePackages = "com.chen.service")
public class CalculateServiceBootstrap {

    private static Logger logger = LoggerFactory.getLogger(CalculateServiceBootstrap.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        // CalculateService Bean 是否存在
        CalculateService calculateService = context.getBean(CalculateService.class);

        logger.info("calculateService.sum(1...10): {}", calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // 关闭上下文
        context.close();
    }

}
