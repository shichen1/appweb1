package com.chen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * java 7 的 for 循环实现 {@link CalculateService}
 */
@Profile("java7")
@Service
public class Java7CalculateService implements CalculateService {

    private static final Logger logger = LoggerFactory.getLogger(Java7CalculateService.class);

    @Override
    public Integer sum(Integer... values) {
        logger.info("Java 7 for 循环实现");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Java7CalculateService java7CalculateService = new Java7CalculateService();
        logger.info("{}", java7CalculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
