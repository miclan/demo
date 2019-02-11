package com.miclan.demo.web;

import com.miclan.demo.domain.App;
import com.miclan.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@RestController
public class HomeController {

    @Resource
    private AppService appService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "demo")
    String demo() {

        return "demo";
    }


    @GetMapping(value = "aaa")
    String aaa() {


        App app = new App();
        app.setAppId(1);
        app.setName("Demo App");
        app.setDescription("This is a demo app.");

        appService.insert(app);

        return "aaaaaa";
    }

    @GetMapping(path = "/app/{appId}")
    App getApp(@PathVariable(value = "appId") Integer appId) {

        return appService.getApp(appId);
    }

    @PostMapping(path = "/create")
    String create(@RequestParam(value = "appId") Integer appId, @RequestParam(value = "name") String name, @RequestParam(value = "description") String description) {

        App app = new App();
        app.setAppId(appId);
        app.setName(name);
        app.setDescription(description);

        appService.insert(app);

        return "OK";
    }

    @GetMapping(path = "/cache")
    String cache() {
        redisTemplate.opsForValue().set("key1", "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789", 3600, TimeUnit.SECONDS);
        return (String) redisTemplate.opsForValue().get("key1");
    }

    @GetMapping(path = "/cache/{key}")
    String getCache(@PathVariable(value = "key") String key) {
//        System.out.println(redisTemplate.getExpire(key, TimeUnit.SECONDS));
        return (String) redisTemplate.opsForValue().get(key);
    }


}
