package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OptionDao;
import com.cafe24.shoppingmall.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionDao optionDao;

    public boolean regOption(OptionVo optionVo) {
        return 1==optionDao.insert(optionVo);
    }
}
