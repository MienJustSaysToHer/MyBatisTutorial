package com.heyuhuan.dao;

import com.heyuhuan.model.Article;
import com.heyuhuan.model.User;

/**
 * 文章DAO类
 *
 * @author Heyuhuan
 * @create 2017-03-06-22:17
 */
public interface ArticleDao {
    Article selectArticle(int id);

    User selectUser(int id);
}
