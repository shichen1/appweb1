package com.chen.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 系统属性条件判断
 */
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String propertyName = String.valueOf(attributes.get("name"));

        String propertyValue = String.valueOf(attributes.get("value"));

        // 根据名称取系统中的值
        String javaPropertyValue = System.getProperty(propertyName);

        // 将自己定义的 value 和系统中取出来的做对比
        return propertyValue.equals(javaPropertyValue);
    }
}
