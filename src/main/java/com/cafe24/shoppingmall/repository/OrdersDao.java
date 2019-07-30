package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.OrdersVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdersDao {
    @Autowired
    private SqlSession sqlSession;

    public int insert(OrdersVo ordersVo) {
        return sqlSession.insert("orders.insert",ordersVo);
    }
//    public int insert(List<OptionDetailVo> optionDetailVo) {
//        return sqlSession.insert("option_detail.insert",optionDetailVo);
//    }
//
    public List<OrdersVo> getList() {
        return sqlSession.selectList("orders.getList");
    }

    public List<OrdersVo> getAllOrdersById(String id) {
        return sqlSession.selectList("orders.getAllOrdersById",id);
    }

    public OrdersVo getOrdersByNonmember(OrdersVo vo) {
        return sqlSession.selectOne("orders.getOrdersByNonmember",vo);
    }
//
//    public OptionDetailVo getOptionDetailByNo(int no) {
//        return sqlSession.selectOne("option_detail.getOptionDetailByNo",no);
//    }
//
//    public int deleteByNo(int no) {
//        return sqlSession.delete("option_detail.deleteByNo",no);
//    }
//
//    public int deleteByOptionNo(int no) {
//        return sqlSession.delete("option_detail.deleteByOptionNo",no);
//    }
//
    public int update(OrdersVo vo) {
        return sqlSession.update("orders.update",vo);
    }

    public int deleteOrderByCode(String code) {
        return sqlSession.update("orders.deleteOrderByCode",code);
    }
}
