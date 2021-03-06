package com.heyuhuan.dao;

import com.heyuhuan.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 博客DAO类
 *
 * @author Heyuhuan
 * @create 2017-03-07-11:53
 */
public interface BlogDao {
    Blog selectBlog(int id);

    void insertBlog(String context);

    void insertBlogs(List<String> contexts);

    Blog selectBlogColumns(int id);

    Blog selectBlogWithContext(@Param("id") int id, @Param("context") String context);

    Blog selectBlogWithDefaultContext(@Param("context") String context);

    Blog selectBlogWithTrim(String context);
}
