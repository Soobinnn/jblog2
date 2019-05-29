package com.cafe24.jblog2.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.BlogVo;
import com.cafe24.jblog2.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 회원가입 **/
	@Override
	public void insert(UserVo userVo)
	{
		sqlSession.insert("users.insert", userVo);
	}
		
	/** 로그인확인 **/
	@Override
	public UserVo getUser(UserVo userVo)
	{
		return sqlSession.selectOne("users.getUser",userVo);
	}
	
	/** 이메일 체크 (ajax) **/
	public Boolean checkId(String id)
	{
		int count = sqlSession.selectOne("users.getId", id);
		return 1 == count;
	}
}
