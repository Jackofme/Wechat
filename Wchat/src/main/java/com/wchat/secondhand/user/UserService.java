package com.wchat.secondhand.user;
import com.wchat.secondhand.Utils.HttpUtils;
import com.wchat.secondhand.Utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    HttpUtils httpUtils;

    @Autowired
    UserMapper userMapper;

    public void getUser(String code, String appId, String appSecretId) {
        String openId = new String();

        Map<String, Object> wxUserOpenid = httpUtils.getWxUserOpenid(code, appId, appSecretId);
        for(String key: wxUserOpenid.keySet()){  // 获取用户的openId
            if(key == "openid"){
                openId = (String) wxUserOpenid.get(key);
            }
        }
        if(userMapper.queryUser(openId).equals(null)){
            User newUser = new User();
            userMapper.insertUser(newUser);
        }
    }
}
