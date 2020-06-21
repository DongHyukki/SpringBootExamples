package com.example.kdh.donghyukkispringboot.sample.redis.controller;

import com.example.kdh.donghyukkispringboot.sample.aop.springaop.LoggingDecorator;
import com.example.kdh.donghyukkispringboot.sample.redis.service.RedisService;
import com.example.kdh.donghyukkispringboot.sample.redis.vo.RedisVO;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/api/redis")
    public String setRedisDataWithHashMap(@RequestBody RedisVO redisVO) {
        String key = redisVO.getKey();
        HashMap<String, Object> map = redisVO.getData();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new LoggingDecorator());
        proxyFactory.setTarget(redisService);

        RedisService redisServiceProxy = (RedisService) proxyFactory.getProxy();
        redisServiceProxy.setListWithMap(key, map);
        return "000";

    }

}
