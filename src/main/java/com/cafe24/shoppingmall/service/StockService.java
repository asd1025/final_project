package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.PhotoDao;
import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.repository.StockDao;
import com.cafe24.shoppingmall.vo.PhotoVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.StockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockDao stockDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PhotoDao photoDao;

    /**
     *  디테일 상품을 등록한다
     *  ex. 나이키 에어맥스 990 빨검 230
     *  ex. 나이키 에어맥스 990 흰검 245
     *  >> 상품재고 테이블에 상품이름과 대표사진 칼럼을 추가로 넣어줬다.
     *  장바구니에서 보여야하는 부분이기에, 역정규화로 칼럼을 추가해줬다.
     *
     * **/
    public boolean regStock(List<StockVo> list) {
        return 0!=stockDao.insert(list);
    }

    /**
     *  상품의 모든 상품 재고(디테일 상품)를 가지고 온다.
     * **/
    public List<StockVo> getListByProductNo(int productNo) {
        return  stockDao.getListByProductNo(productNo);
    }


    /**
     *  재고 상품을 보여준다
    * **/
    public StockVo getStockByStockNo(int stockNo) {
        return stockDao.getStockByStockNo(stockNo);
    }

    /***
     *  주문 후 상품재고 수량 변경
     *  재고보다 많은 양을 주문하는 경우는 false
     */
    public boolean updateAfterOrder(int stockNo,int qnty) {
        StockVo stockVo=stockDao.getStockByStockNo(stockNo);
        if(stockVo==null) return false;
        if(stockVo.getAmount()<qnty) return false;
        return 0!=stockDao.updateAfterOrder(stockVo,qnty);
    }

    public boolean updateStock(StockVo vo) {
        return 0!=stockDao.updateStock(vo);
    }
//
//     // 수정이 필요한 부분,,,
//    public boolean deleteProduct(int no) {
//        return 0!=productDao.delete(no);
//    }
//
//    public boolean updateProduct(ProductVo productVo) {
//        return 0!=productDao.update(productVo);
//    }
}
