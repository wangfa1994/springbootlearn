package com.wf.repository;


import com.wf.annotation.FirstLevelRepository;
import com.wf.annotation.SecondLevelRepository;

/**
 * 我的 {@link FirstLevelRepository}
 *
 * @author 小马哥
 * @since 2018/5/14
 */
@SecondLevelRepository(value = "myFirstLevelRepository") // Bean 名称
public class MyFirstLevelRepository {
}
