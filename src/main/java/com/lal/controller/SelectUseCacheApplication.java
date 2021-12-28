package com.lal.controller;

import com.lal.entity.Department;
import com.lal.mapper.DepartmentMapper;
import com.lal.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SelectUseCacheApplication {
    public static void main(String[] args) throws Exception {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 连续查询两次同一个Department
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println(department);
        Department department2 = departmentMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println("department == department2 : " + (department == department2));
        // 关闭第一个SqlSession使二级缓存保存
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper2 = sqlSession2.getMapper(DepartmentMapper.class);
        // 再次查询Department
        Department department3 = departmentMapper2.findById("18ec781fbefd727923b0d35740b177ab");
        departmentMapper2.findAll();

        UserMapper userMapper = sqlSession2.getMapper(UserMapper.class);
        // 触发缓存清除
        userMapper.cleanCache();
        System.out.println("==================cleanCache====================");

        // 再再次查询Department
        Department department4 = departmentMapper2.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println("department3 == department4 : " + (department3 == department4));

        sqlSession2.close();
    }
}
