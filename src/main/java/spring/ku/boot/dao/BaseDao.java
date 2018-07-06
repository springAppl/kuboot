package spring.ku.boot.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import spring.ku.boot.criteria.SimplePage;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.List;

/**
 * @author lsf
 */
public class BaseDao<T> {

    @Autowired
    private SqlSession sqlSession;


    private String typeName;

    public BaseDao(){
        ParameterizedTypeImpl type = (ParameterizedTypeImpl) this.getClass().getGenericSuperclass();
        String[] array = type.getActualTypeArguments()[0].getTypeName().split("\\.");
        typeName = array[array.length - 1] + ".";
    }

    public Integer create(T t) {
        return sqlSession.insert(mapperName("create"), t);
    }

    public Integer update(T t) {
        return sqlSession.update(mapperName("update"), t);
    }

    public T findByID(Long id) {
        return sqlSession.selectOne(mapperName("findByID"), id);
    }

    public String mapperName(String query){
        return typeName + query;
    }

    public SimplePage<T> paging(PageCriteria pageCriteria){
        List<T> list = sqlSession.selectList(mapperName("paging"), pageCriteria);
        Integer total = sqlSession.selectOne(mapperName("count"), pageCriteria);
        Integer pages = total/pageCriteria.getPageSize() + (total % pageCriteria.getPageSize() > 0 ? 1:0);
        return new SimplePage<>(total, pages, list );
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }
}
