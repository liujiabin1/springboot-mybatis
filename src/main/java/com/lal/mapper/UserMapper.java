package com.lal.mapper;

import com.lal.entity.User;

import java.util.List;


public interface UserMapper {

    List<User> findAll();

    List<User> findAllLazy();

    List<User> findAllByDepartmentId(int departmentId);

    int cleanCache();
}
