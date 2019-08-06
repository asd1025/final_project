package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.*;
import com.cafe24.shoppingmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private OptionDao optionDao;
    @Autowired
    private OptionDetailDao optionDetailDao;
    @Autowired
    private StockDao stockDao;


    /**
     *  상품을 등록한다. 이때의 상품은 전체적인 상품(parent)을 말한다.
     *  ex. 나이키 에어맥스 990
     *  *  상품 등록시,  상품등록 /사진리스트 / 옵션등록 / 옵션디테일등록 / 상품재고등록 순으로 이루어진다!
     * **/
    @Transactional
    public boolean regProduct(ProductVo productVo) {
        return productDao.insert(productVo)&&photoDao.insert(productVo.getPhotos())&&optionDao.insert(productVo.getOptions())
                &&optionDetailDao.insert(productVo.getOptionDetails())&&stockDao.insert(productVo.getStocks());
    }

    /**
     *  등록된 상품을 다 보여준다. 이떄의 상품은 전체적인 상품(parent)을 말한다.
     * **/
    public List<ProductVo> getList() {
       List<ProductVo> list=productDao.getList();
       if(list.size()==0) return null;
       int no=list.get(0).getProductNo();
       for(ProductVo vo :list){
           vo.setPhotos(photoDao.getListByProductNo(no));
           vo.setOptions(optionDao.getListByProductNo(no));
//           고쳐야해!!!!!!!!!!!!!!!!!!!!! ㄷㄴㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ
//           vo.setOptionDetails(optionDetailDao);
       }
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
