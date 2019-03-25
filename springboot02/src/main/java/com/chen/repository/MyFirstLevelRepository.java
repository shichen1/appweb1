package com.chen.repository;

import com.chen.annotation.FirstLevelRepository;
import com.chen.annotation.SecondLevelRepository;

/**
 * 我的 {@link com.chen.annotation.SecondLevelRepository}
 */
@SecondLevelRepository(value = "myFirstLevelRepository") // Bean 名称
public class MyFirstLevelRepository {
}
