package com.lal.impl;

import com.lal.dao.DepartmentDao;
import com.lal.entity.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DepartmentImpl implements DepartmentDao {

    private SqlSessionFactory sqlSessionFactory;

    public DepartmentImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Department> findAll() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectList("departmentMapper.findAll");

        }
    }

    @Override
    public Department findById(String id) {

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne("departmentMapper.findById",id);

        }
    }
}
