package com.heyuhuan.dao;

import com.heyuhuan.model.Blog;

import java.util.List;

/**
 * @author Heyuhuan
 * @create 2017-03-07-11:53
 */

public interface BlogDao {
    Blog selectBlog(int id);

    void insertBlog(String context);

    void insertBlogs(List<String> contexts);
}
