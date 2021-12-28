package com.lal.dao;

import com.lal.entity.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> findAll();

    Department findById(String id);
}
