package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.PhotoVo;
import com.cafe24.shoppingmall.vo.StockVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockDao {
    @Autowired
    SqlSession sqlSession;

    public int insert(List<StockVo> stockVo) {
        return sqlSession.insert("stock.insert",stockVo);
    }

    public List<StockVo> getListByProductNo(int productNo) {
        return sqlSession.selectList("stock.getListByProductNo",productNo);
    }

    public StockVo getStockByStockNo(int stockNo) {
        return sqlSession.selectOne("stock.get",stockNo);
    }

    public int updateAfterOrder(StockVo stockVo,int qnty) {
        Map<String,Object> map =new HashMap<>();
        map.put("stockVo",stockVo);
        map.put("qnty",qnty);
        return sqlSession.update("stock.updateAfterOrder",map);
    }

    public int updateStock(StockVo vo) {
        System.out.printf("vo: "+vo);
        return sqlSession.update("stock.update",vo);
    }
//
//    public ProductVo get(int no) {
//        return sqlSession.selectOne("product.get",no);
//    }
//
//    public int delete(int no) {
//        return sqlSession.delete("product.delete",no);
//    }
//
//    public int update(ProductVo productVo) {
//        return sqlSession.update("product.update",productVo);
//    }
}
