package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OrdersDao;
import com.cafe24.shoppingmall.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public boolean doOrder(OrdersVo ordersVo) {
        return 0!=ordersDao.insert(ordersVo);
    }
    public List<OrdersVo> getList() {
        return ordersDao.getList();
    }
//
//    public boolean deleteOptionBynNo(int no) {
//        return 0!=optionDao.deleteByNo(no);
//    }
//
    public List<OrdersVo> getAllOrdersById(String id) {
        return ordersDao.getAllOrdersById(id);
    }

    public OrdersVo getOrdersByNonmember(OrdersVo vo) {
        return ordersDao.getOrdersByNonmember(vo);
    }

    public boolean update(OrdersVo vo) {
        return 0!=ordersDao.update(vo);
    }

    public boolean deleteOrder(String code) {
        return 0!=ordersDao.deleteOrderByCode(code);
    }
//
//    public List<OptionVo> getOptionByProductNo(int no) {
//        return optionDao.getListByProductNo(no);
//    }
//
//    public boolean updateOption(OptionVo optionVo) {
//        return 0!=optionDao.updateOption(optionVo);
//    }
}
