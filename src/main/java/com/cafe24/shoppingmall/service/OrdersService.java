package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;
}
