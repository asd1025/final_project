package com.cafe24.shoppingmall.repository;


import com.cafe24.shoppingmall.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private SqlSession sqlSession;


    /***
     * 회원가입
     */
    public boolean insert(UserVo vo){
          return 1==sqlSession.insert("user.join", vo);
      }

    /***
     * 아이디가 존재하면 true -> 아이디 사용 불가
     * 아이디가 없다면 false -> 아이디 사용 가능
     */
    public boolean checkById(String id){
        return (sqlSession.selectOne("user.checkById", id)!=null)?true:false;
    }

    /***
     * 로그인 성공 userVo
     * 로그인 실패  null
     */
    public UserVo login(UserVo userVo) {
        return sqlSession.selectOne("user.login",userVo);
    }

    public int update(UserVo userVo) {
        return sqlSession.update("user.update",userVo);
    }
}
