package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.CartVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartDao {
    @Autowired
    private SqlSession sqlSession;

    public List<CartVo> getList(String id){
        return sqlSession.selectList("cart.getList",id);
    }

    public boolean insert(CartVo cartVo) {
        return 1==sqlSession.insert("cart.insert",cartVo);
    }

    public int deleteCartByNo(int stockNo, String id) {
        Map<String,Object> map=new HashMap<>();
        map.put("stockNo",stockNo);
        map.put("id",id);
        return sqlSession.delete("cart.deleteCartByNo",map);
    }
    public int deleteAllCartById( String id) {
        return sqlSession.delete("cart.deleteAllCartById",id);
    }


    public CartVo getCartByIdAndStockNo(CartVo cartVo) {
        return sqlSession.selectOne("cart.getCartByIdAndStockNo",cartVo);
    }
    public List<CartVo> getListByStockNo(int no) {
        return sqlSession.selectList("cart.getListByStockNo",no);
    }

    public int updateCartQuantity(CartVo cartVo, int quantity) {
        Map<String,Object> map=new HashMap<>();
        map.put("cartVo",cartVo);
        map.put("quantity",quantity);
        return sqlSession.update("cart.updateCartQuantity",map);
    }


    public int update(CartVo cartVo){
        return sqlSession.update("cart.update",cartVo);
    }

    public int updateDelete(int stockNo){
        return sqlSession.update("cart.updateDelete",stockNo);
    }

}
