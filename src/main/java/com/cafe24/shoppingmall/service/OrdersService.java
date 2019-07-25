package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OrdersDao;
import com.cafe24.shoppingmall.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public boolean doOrder(OrdersVo ordersVo) {
        return 0!=ordersDao.insert(ordersVo);
    }
//    public List<OptionVo> getList() {
//        return optionDao.getList();
//    }
//
//    public boolean deleteOptionBynNo(int no) {
//        return 0!=optionDao.deleteByNo(no);
//    }
//
//    public OptionVo getOptionByNo(int no) {
//        return optionDao.getOptionByNo(no);
//    }
//
//    public List<OptionVo> getOptionByProductNo(int no) {
//        return optionDao.getListByProductNo(no);
//    }
//
//    public boolean deleteOptionByProductNo(int no) {
//        return 0!=optionDao.deleteOptionByProductNo(no);
//    }
//
//    public boolean updateOption(OptionVo optionVo) {
//        return 0!=optionDao.updateOption(optionVo);
//    }
}
