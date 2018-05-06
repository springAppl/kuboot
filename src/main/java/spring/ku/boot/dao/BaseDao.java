package spring.ku.boot.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<T> paging(PageCriteria pageCriteria){
        return sqlSession.selectList(mapperName("paging"), pageCriteria);
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }
}
