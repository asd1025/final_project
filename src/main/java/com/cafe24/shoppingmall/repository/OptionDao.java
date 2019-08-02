package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.OptionVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OptionDao {
    @Autowired
    private SqlSession sqlSession;

    public boolean insert(List<OptionVo> optionVo) {
        return optionVo.size()==sqlSession.insert("option.insert",optionVo);
    }

    public List<OptionVo> getList() {
        return sqlSession.selectList("option.getList");
    }

    public int deleteByNo(int no) {
        return sqlSession.delete("option.deleteByNo",no);
    }

    public OptionVo getOptionByNo(int no) {
        return sqlSession.selectOne("option.getOptionByNo",no);
    }

    public List<OptionVo> getListByProductNo(int no) {
        return sqlSession.selectList("option.getListByProductNo",no);
    }

    public int deleteOptionByProductNo(int no) {
        return sqlSession.delete("option.deleteOptionByProductNo",no);

    }

    public int updateOption(OptionVo optionVo) {
        return sqlSession.update("option.update",optionVo);

    }



}
