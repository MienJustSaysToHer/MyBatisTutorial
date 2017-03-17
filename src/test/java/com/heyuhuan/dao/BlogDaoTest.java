package com.heyuhuan.dao;

import com.heyuhuan.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 博客DAO测试类
 *
 * @author Heyuhuan
 * @create 2017-03-07-11:38
 */
public class BlogDaoTest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void find() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //Blog blog = (Blog) session.selectOne("com.heyuhuan.dao.BlogDao.selectBlog", 1);
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlog(1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    @Test
    public void insertBlog() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            blogDao.insertBlog("2");
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void insertBlogs() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            blogDao.insertBlogs(Arrays.asList("3", "4"));
            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void selectBlogColumns() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlogColumns(1);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectBlogWithContext() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlogWithContext(1, "%%2%%");
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectBlogWithDefaultContext() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlogWithDefaultContext("23");
            System.out.println(blog);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectBlogWithTrim() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlogWithTrim("23");
            System.out.println(blog);
        } finally {
            session.close();
        }
    }
}
