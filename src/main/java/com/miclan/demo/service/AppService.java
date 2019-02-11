package com.miclan.demo.service;

import com.miclan.demo.domain.App;
import com.miclan.demo.mapper.AppMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppService {

    @Resource
    private AppMapper appMapper;

    public int insert(App record) {
        return appMapper.insert(record);
    }

    public App getApp(int appId) {
        return appMapper.getApp(appId);
    }

    public int insertSelective(App record) {
        return appMapper.insertSelective(record);
    }

}
