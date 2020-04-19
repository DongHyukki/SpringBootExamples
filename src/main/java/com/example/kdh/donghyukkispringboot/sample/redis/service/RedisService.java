package com.example.kdh.donghyukkispringboot.sample.redis.service;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class RedisService {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, HashMap<String, Object>> listOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    public void setListWithMap(String keyData, HashMap<String, Object> hashData) {
        listOperations.leftPush(keyData, hashData);
    }
//
//
//    public void setUserToken(String email, String accessToken, String refreshToken) {
//        Map<String, String> userTokenMap = new HashMap<String, String>();
//        userTokenMap.put("AccessToken", accessToken);
//        userTokenMap.put("RefreshToken", refreshToken);
//        //이미 레디스에 로그인 된 정보가 있다면 삭제한다.
//        if(isSetUserToken(email)) {
//            listOperations.leftPop(email);
//        }
//        listOperations.leftPush(email, userTokenMap);
//    }
//
//    public Boolean deleteUserToken(String token) {
//        String sc = lProperties.getProperty("login.secret");
//        TokenHandler tokenHandler = new TokenHandler(sc);
//        String email = tokenHandler.parseUserFromToken(token);
//        listOperations.leftPop(email);
//        return listOperations.size(email) == 0;
//    }
//
//    public String getUserAccessToken(String email) {
//        if(isSetUserToken(email)) {
//            List<Map<String, String>> userTokenMap = listOperations.range(email, 0, 0);
//            return userTokenMap.get(0).get("AccessToken");
//        } else {
//            return null;
//        }
//    }
//
//    public String getUserRefreshToken(String email) {
//        if(isSetUserToken(email)) {
//            List<Map<String, String>> userTokenMap = listOperations.range(email, 0, 0);
//            return userTokenMap.get(0).get("RefreshToken");
//        } else {
//            return null;
//        }
//    }
//
//    public Boolean isSetUserToken(String email) {
//        return listOperations.size(email) > 0;
//    }

    public Long getListSize(String key) {
        return listOperations.size(key);
    }
}