package com.example.kdh.donghyukkispringboot.sample.redis.controller;

import com.example.kdh.donghyukkispringboot.sample.redis.service.RedisService;
import com.example.kdh.donghyukkispringboot.sample.redis.vo.RedisVO;
import lombok.RequiredArgsConstructor;
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
        System.out.println("!!!!!!!!!!!!!");
        System.out.println(key);
        HashMap<String, Object> map = redisVO.getData();
        System.out.println(map.containsKey("data1"));
        System.out.println(map.containsValue("data1"));
        System.out.println("!!!!!!!!!!!!!");
        redisService.setListWithMap(key, map);
        return "000";
    }

}
