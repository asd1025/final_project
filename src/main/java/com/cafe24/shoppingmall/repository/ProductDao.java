package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.ProductVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    SqlSession sqlSession;

    public boolean insert(ProductVo productVo) {
        return 1==sqlSession.insert("product.insert",productVo);
    }

    public List<ProductVo> getList() {
        return sqlSession.selectList("product.getList");
    }

    public ProductVo get(int no) {
        return sqlSession.selectOne("product.get",no);
    }

    public int delete(int no) {
        return sqlSession.delete("product.delete",no);
    }

    public int update(ProductVo productVo) {
        return sqlSession.update("product.update",productVo);
    }
}
