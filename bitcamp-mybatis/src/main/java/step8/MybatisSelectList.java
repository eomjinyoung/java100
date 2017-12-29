package step8;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSelectList {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step8/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // 정렬 정보를 맵 객체에 담아 selectList()에 넘긴다.
        Map<String,Object> data = new HashMap<>();
        data.put("orderColumn", "title");
        data.put("align", "desc");
        
        List<Board> records = sqlSession.selectList(
                "JdbcTestMapper.findAll", data);
        
        for (Board board : records) {
            System.out.printf("%d,%s,%s,%s\n", 
                    board.getNo(),
                    board.getTitle(),
                    board.getCreatedDate(),
                    board.getViewCount());
        }
        
        sqlSession.close();
    }
}
