package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.CategoryDao;
import com.cafe24.shoppingmall.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public boolean regCategory(CategoryVo categoryVo) {
        return 1==categoryDao.insert(categoryVo);
    }


    public List<CategoryVo> getList() {
        return categoryDao.getList();
    }

    public CategoryVo getCategoryByNo(int no) {
        return categoryDao.getCategory(no);
    }


    @Transactional
    public boolean deleteCategoryByNo(int no) {
        return (categoryDao.deleteCategory(no)!=0)&&(categoryDao.updateCategroy(no)!=0);
    }

    public boolean updateCategory(CategoryVo categoryVo) {
        return 0!=categoryDao.update(categoryVo);
    }
}
