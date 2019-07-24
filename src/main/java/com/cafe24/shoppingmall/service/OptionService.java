package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OptionDao;
import com.cafe24.shoppingmall.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionDao optionDao;

    public boolean regOption(List<OptionVo> optionVo) {
        return 0!=optionDao.insert(optionVo);
    }

    public List<OptionVo> getList() {
        return optionDao.getList();
    }

    public boolean deleteOptionBynNo(int no) {
        return 0!=optionDao.deleteByNo(no);
    }

    public OptionVo getOptionByNo(int no) {
        return optionDao.getOptionByNo(no);
    }

    public List<OptionVo> getOptionByProductNo(int no) {
        return optionDao.getListByProductNo(no);
    }

    public boolean deleteOptionByProductNo(int no) {
        return 0!=optionDao.deleteOptionByProductNo(no);
    }

    public boolean updateOption(OptionVo optionVo) {
        return 0!=optionDao.updateOption(optionVo);
    }
}
