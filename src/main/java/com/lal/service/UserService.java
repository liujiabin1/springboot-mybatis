package com.lal.service;

import com.lal.entity.User;
import com.lal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String findUser() {
        User user = userMapper.findUserById(1);

        if (user == null) {
            return "找不到用户";
        }
        return "用户名：" + user.getUserName() + " " +
                "用户密码：" + user.getPassword() + " " +
                "用户真实名:" + user.getRealName();
    }
}
