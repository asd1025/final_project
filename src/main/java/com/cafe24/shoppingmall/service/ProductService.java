package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    /**
     *  상품을 등록한다. 이때의 상품은 전체적인 상품(parent)을 말한다.
     *  ex. 나이키 에어맥스 990
     * **/
    public boolean regProduct(ProductVo productVo) {

        return productDao.insert(productVo);
    }

    /**
     *  등록된 상품을 다 보여준다. 이떄의 상품은 전체적인 상품(parent)을 말한다.
     * **/
    public List<ProductVo> getList() {
        return  productDao.getList();
    }


    /**
     *  해당 번호의 상품을 보여준다.이떄의 상품은 전체적인 상품(parent)을 말한다.
     * **/
    public ProductVo getProductByNo(int no) {
        return  productDao.get(no);
    }

     // 수정이 필요한 부분,,,
    public boolean deleteProduct(int no) {
        return 0!=productDao.delete(no);
    }

    public boolean updateProduct(ProductVo productVo) {
        return 0!=productDao.update(productVo);
    }
}
