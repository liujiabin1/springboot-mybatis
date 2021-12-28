package com.lal.service;

import com.lal.entity.User;
import com.lal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String findUser() {
        List<User> users = userMapper.findAll();

        if (CollectionUtils.isEmpty(users)) {
            return "找不到用户";
        }
        User user = users.get(0);
        return "用户名：" + user.getName() + " " +
                "用户密码：" + user.getAge() + " " +
                "用户真实名:" + user.getDepartment().getName();
    }
}
