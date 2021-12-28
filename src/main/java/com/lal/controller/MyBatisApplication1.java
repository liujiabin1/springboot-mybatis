package com.lal.controller;

import com.lal.entity.Department;
import com.lal.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisApplication1 {
//    public static void main(String[] args) throws Exception {
//        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
//        DepartmentDao departmentDao = new DepartmentImpl(sqlSessionFactory);
//        List<Department> departmentList = departmentDao.findAll();
//        departmentList.forEach(System.out::println);
//    }

    //单表增删改查
//    public static void main(String[] args) throws Exception {
//        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //获取mapper接口的代理
//        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
//
//        List<Department> departmentList = departmentMapper.findAll();
//        departmentList.forEach(System.out::println);
//    }

    //关联表查询
//    public static void main(String[] args) throws Exception {
//        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findAll();
//        userList.forEach(System.out::println);
//    }

    //延迟加载
//    public static void main(String[] args) throws Exception {
//        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findAllLazy();
//        userList.forEach(System.out::println);
//    }

    //部门-用户 1对多
    public static void main(String[] args) throws Exception {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.findById("18ec781fbefd727923b0d35740b177ab");
        System.out.println(department);
        System.out.println(department.getUsers());
    }
}
