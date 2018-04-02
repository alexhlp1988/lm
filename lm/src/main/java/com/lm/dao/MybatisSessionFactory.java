package com.lm.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工厂管理会话 (获取 | 关闭)
 */
public class MybatisSessionFactory {
  private static SqlSessionFactory factory;
  private static String resource = "mybatis-config.xml";
  // 线程本地变量:SqlSession 在同一进程多个线程中共享
  private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

  // 单例模式
  static {
    try {
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 外部类不能实例化当前类
  private MybatisSessionFactory() {

  }

  /**
   * 重建会话工厂对象
   */
  public static void rebuildSessionFactory() {
    try {
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取 mybatis 会话对象:SqlSession
   *
   * @return
   */
  public static SqlSession getSession() {
    // 从线程本地变量中获取 SqlSession
    SqlSession session = threadLocal.get();
    if (session == null) {
      if (factory == null) {
        rebuildSessionFactory();
      }
      // 当会话工厂对象已实例化时获取 SqlSession
      session = (factory != null) ? factory.openSession() : null;
      threadLocal.set(session);
    }
    return session;
  }

  /**
   * 关闭会话对象:SqlSession
   */
  public static void closeSession() {
    SqlSession session = threadLocal.get();
    threadLocal.set(null);

    if (session != null) {
      session.close();
    }
  }
}
