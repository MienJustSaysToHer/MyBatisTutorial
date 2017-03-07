import com.heyuhuan.dao.BlogDao;
import com.heyuhuan.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Heyuhuan
 * @create 2017-03-07-11:38
 */

public class SessionFactoryTest {
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
}
