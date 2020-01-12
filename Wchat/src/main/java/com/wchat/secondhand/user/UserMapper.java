package com.wchat.secondhand.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    public User queryUser(String openid);
    public int insertUser(User user);

}
