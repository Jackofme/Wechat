package com.wchat.secondhand.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String name;
    private String password;
}
