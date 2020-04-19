package com.example.kdh.donghyukkispringboot.sample.redis.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Data
@RequiredArgsConstructor
public class RedisVO {
    private String key;
    private HashMap<String, Object> data;
}
