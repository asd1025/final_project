package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.CategoryVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDao {
    @Autowired
    private SqlSession sqlSession;

    public int insert(CategoryVo categoryVo) {
        return sqlSession.insert("category.insert",categoryVo);
    }

    public List<CategoryVo> getList() {
        return sqlSession.selectList("category.getList");
    }

    public CategoryVo getCategory(int no) {
        return sqlSession.selectOne("category.getCategory",no);
    }

    public int deleteCategory(int no) {

        return sqlSession.delete("category.deleteCategory",no);
    }

    public int updateCategroy(int no){
        Map<String,Object>  map=new HashMap<>();
        // 7번 default 미분류 사용
        map.put("default",7);
        map.put("parent_category",no);
        return sqlSession.update("category.updateDefault",map);
    }


    public int update(CategoryVo categoryVo) {
        return sqlSession.update("category.update",categoryVo);
    }
}
