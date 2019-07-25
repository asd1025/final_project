package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.OptionDetailVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionDetailDao {
    @Autowired
    private SqlSession sqlSession;

    public int insert(List<OptionDetailVo> optionDetailVo) {
        return sqlSession.insert("option_detail.insert",optionDetailVo);
    }

    public List<OptionDetailVo> getList() {
        return sqlSession.selectList("option_detail.getList");
    }

    public List<OptionDetailVo> getOptionDetailByOptionNo(int no) {
            return sqlSession.selectList("option_detail.getOptionDetailByOptionNo",no);
    }

    public OptionDetailVo getOptionDetailByNo(int no) {
        return sqlSession.selectOne("option_detail.getOptionDetailByNo",no);
    }

    public int deleteByNo(int no) {
        return sqlSession.delete("option_detail.deleteByNo",no);
    }

    public int deleteByOptionNo(int no) {
        return sqlSession.delete("option_detail.deleteByOptionNo",no);
    }

    public int update(OptionDetailVo optionDetailVo) {
        return sqlSession.update("option_detail.update",optionDetailVo);
    }

}
