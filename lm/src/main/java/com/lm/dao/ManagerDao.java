package com.lm.dao;

import com.lm.condition.ManagerCondition;
import com.lm.pojo.Manager;
import com.lm.util.Pager;

import java.util.List;

public class ManagerDao {
    public Pager<Manager> find(ManagerCondition managerCondition) {
        Pager<Manager> pager = new Pager<>();
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            Integer page = managerCondition.getPage();
            Integer rows = managerCondition.getRows();
            managerCondition.setPage((page - 1) * rows);
            managerCondition.setRows(page * rows);
            //分页数据总数
            pager.setTotal(mapper.findPageTotal(managerCondition));
            pager.setRows(mapper.findPage(managerCondition));
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return pager;
    }

    public Manager find(Integer id) {
        Manager manager = null;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            manager = mapper.findById(id);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return manager;
    }

    public int add(Manager manager) {
        int count = 0;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            count = mapper.add(manager);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public int modify(Manager manager) {
        int count = 0;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            count = mapper.modify(manager);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public int remove(Integer id) {
        int count = 0;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            count = mapper.remove(id);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    //验证用户名密码
    public Manager checkPwd(String mname, String password) {
        Manager manager = null;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            manager = mapper.checkPwd(mname, password);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return manager;
    }

    //根据用户名返回manager对象
    public Manager checkMname(String mname) {
        Manager manager = null;
        try {
            ManagerMapper mapper = MybatisSessionFactory.getSession().getMapper(ManagerMapper.class);
            manager = mapper.checkMname(mname);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return manager;
    }

}
