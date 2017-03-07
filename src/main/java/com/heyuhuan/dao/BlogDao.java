package com.heyuhuan.dao;

import com.heyuhuan.model.Blog;

/**
 * @author Heyuhuan
 * @create 2017-03-07-11:53
 */

public interface BlogDao {
    Blog selectBlog(int id);
}
