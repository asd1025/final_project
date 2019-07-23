package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.OptionVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OptionDao {
    @Autowired
    private SqlSession sqlSession;

    public int insert(OptionVo optionVo) {
        return sqlSession.insert("option.insert",optionVo);
    }

//    public List<CartVo> getList(String id){
//        return sqlSession.selectList("cart.getList",id);
//    }
//
//    public int deleteCartByNo(int stockNo, String id) {
//        Map<String,Object> map=new HashMap<>();
//        map.put("stockNo",stockNo);
//        map.put("id",id);
//        return sqlSession.delete("cart.deleteCartByNo",map);
//    }
//    public int deleteAllCartById( String id) {
//        return sqlSession.delete("cart.deleteAllCartById",id);
//    }
//
//
//    public CartVo getCartByIdAndStockNo(CartVo cartVo) {
//        return sqlSession.selectOne("cart.getCartByIdAndStockNo",cartVo);
//    }
//
//    public int updateCartQuantity(CartVo cartVo, int quantity) {
//        Map<String,Object> map=new HashMap<>();
//        map.put("cartVo",cartVo);
//        map.put("quantity",quantity);
//        return sqlSession.update("cart.updateCartQuantity",map);
//    }


//    public int update(CartVo cartVo){
//        return sqlSession.update("cart.update",cartVo);
//    }


}
