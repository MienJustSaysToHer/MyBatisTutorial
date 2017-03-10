package com.heyuhuan.dao;

import com.heyuhuan.model.Article;
import com.heyuhuan.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文章DAO测试类
 *
 * @author Heyuhuan
 * @create 2017-03-10-16:35
 */
public class ArticleDaoTest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectArticle() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.selectArticle(2);
            System.out.println(article.getId());
            System.out.println(article.getUser().getId());
        } finally {
            session.close();
        }
    }

    @Test
    public void selectUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            User user = articleDao.selectUser(1);
            System.out.println(user.getArticles().size());
        } finally {
            session.close();
        }
    }
}
