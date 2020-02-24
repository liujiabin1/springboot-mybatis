package com.lal.entity;

import lombok.Data;

@Data
public class User {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真正的名字
     */
    private String realName;
}
