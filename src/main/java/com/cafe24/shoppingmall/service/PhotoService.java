package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OptionDetailDao;
import com.cafe24.shoppingmall.repository.PhotoDao;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.cafe24.shoppingmall.vo.PhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoDao photoDao;

    public boolean regPhotos(List<PhotoVo> photoVo) {
        return photoDao.insert(photoVo)!=0;
    }

//    public List<OptionDetailVo> getList() {
//        return optionDetailDao.getList();
//    }
//
//    public List<OptionDetailVo> getOptionDetailByOptionNo(int no) {
//        return optionDetailDao.getOptionDetailByOptionNo(no);
//    }
//
//    public OptionDetailVo getOptionDetailByNo(int no) {
//        return optionDetailDao.getOptionDetailByNo(no);
//    }
//
//    public boolean deleteOptionDetailBynNo(int no) {
//        return 0!=optionDetailDao.deleteByNo(no);
//    }
//
//    public boolean deleteOptionDetailByOptionNo(int no) {
//        return 0!=optionDetailDao.deleteByOptionNo(no);
//    }
//
//    public boolean updateOptionDetail(OptionDetailVo optionDetailVo) {
//        return 0!=optionDetailDao.update(optionDetailVo);
//    }
}
