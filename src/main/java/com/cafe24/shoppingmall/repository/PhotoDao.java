package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.PhotoVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoDao {
    @Autowired
    SqlSession sqlSession;

    public int insert(List<PhotoVo> photoVo) {
        return sqlSession.insert("photo.insert",photoVo);
    }

    public List<PhotoVo> getListByProductNo(int productNo) {
        return sqlSession.selectList("photo.getListByProductNo",productNo);
    }

    public int deletePhotoByProductNo(int no) {
        return sqlSession.delete("photo.delete",no);
    }

//    public List<ProductVo> getList() {
//        return sqlSession.selectList("product.getList");
//    }
//
//    public ProductVo get(int no) {
//        return sqlSession.selectOne("product.get",no);
//    }
//
//    public int update(ProductVo productVo) {
//        return sqlSession.update("product.update",productVo);
//    }
}
