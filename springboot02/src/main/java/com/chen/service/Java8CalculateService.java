package com.chen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * java 8 的 Lambda 实现 {@link CalculateService}
 */
@Profile("java8")
@Service
public class Java8CalculateService implements CalculateService {

    private static final Logger logger = LoggerFactory.getLogger(Java8CalculateService.class);

    @Override
    public Integer sum(Integer... values) {
        logger.info("Java 8 Lambda 实现");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }

    public static void main(String[] args) {
        Java8CalculateService java8CalculateService = new Java8CalculateService();
        logger.info("{}", java8CalculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
