package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.OptionDetailDao;
import com.cafe24.shoppingmall.repository.PhotoDao;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.cafe24.shoppingmall.vo.PhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoDao photoDao;

    public boolean regPhotos(List<PhotoVo> photoVo) {
        return photoDao.insert(photoVo);
    }

    public List<PhotoVo> getListByProductNo(int productNo) {
        return photoDao.getListByProductNo(productNo);
    }
    public PhotoVo getThumbImgByProducNo(int productNo) {
        return photoDao.getThumbImgByProducNo(productNo);
    }


    /***
     *  사진을 수정하는 것은
     *  기존 사진을 삭제하고 다시 넣어준다.
     * */
    @Transactional
    public boolean update(int productNo, List<PhotoVo> photoList) {
            if(photoList.size()==0) return false;
          return deletePhotoByProductNo(productNo)&& regPhotos(photoList);
    }

/**
 *  상품 사진을 삭제한다
 * */
    public boolean deletePhotoByProductNo(int no) {
        return 0!=photoDao.deletePhotoByProductNo(no);
    }

}
