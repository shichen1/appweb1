package com.chen.configuration;

import com.chen.annotation.EnableHelloWorld;
import com.chen.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Hello World 自动装配
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "chen") // 条件装配
public class HelloWorldAutoConfiguration {
}
