package com.lm.test;

import com.lm.condition.ManagerCondition;
import com.lm.dao.ManagerDao;
import com.lm.pojo.Manager;
import com.lm.util.MD5;
import com.lm.util.Pager;
import org.junit.Before;
import org.junit.Test;

public class ManagerDaoTest {
    private ManagerDao dao;

    @Test
    public void checkMname(){
        String mname="test";
        boolean flag = dao.checkMname(mname) == null?true:false;
        System.out.println(flag);
    }

    @Test
    public void checkPwd(){
        String mname="admin";
        String password= MD5.getMD5("12345678");
        Manager manager = dao.checkPwd(mname,password);
        System.out.println(manager.getRights());
    }

    @Test
    public void add(){
        Manager manager = new Manager();
        manager.setMname("test");
        manager.setPassword("123123");
        manager.setRights("test");
        int count = dao.add(manager);
        if (count > 0) {
            System.out.println("ok");
        }
    }

    @Test
    public void modify(){
        Manager manager = new Manager();
        manager.setId(2);
        manager.setMname("test");
        manager.setPassword("123456");
        manager.setRights("test");
        int count = dao.modify(manager);
        if (count > 0) {
            System.out.println("ok");
        }
    }

    @Test
    public void remove(){
        int count = dao.remove(2);
        if (count > 0) {
            System.out.println("ok");
        }
    }

    @Test
    public void findById(){
        Manager manager = dao.find(1);
        System.out.println(manager.getMname());
    }
    @Test
    public void findpage(){
        //必须参数
        Integer page = 1;
        Integer rows = 5;
        String sort = "price";
        String order = "asc";
        //可选参数
        String mname = null;
        //封装查询条件
        ManagerCondition managerCondition = new ManagerCondition();
        managerCondition.setPage(page);
        managerCondition.setRows(rows);
        managerCondition.setSort(sort);
        managerCondition.setOrder(order);
        managerCondition.setMname(mname);
        //执行分页查询
        Pager<Manager> pager = dao.find(managerCondition);
        System.out.println("分页数据总数："+pager.getTotal());
        for(Manager manager : pager.getRows()){
            System.out.println(manager.getMname());
        }
    }
    @Before
    public void init(){
        dao = new ManagerDao();
    }
}
