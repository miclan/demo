package com.miclan.demo.mapper;

import com.miclan.demo.domain.App;

public interface AppMapper {
    int insert(App record);

    App getApp(int appId);

    int insertSelective(App record);
}