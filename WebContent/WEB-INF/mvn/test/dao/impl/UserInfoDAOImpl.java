package com.mvn.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList", pUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	public int insertList(UserInfoVO pUser) {
		SqlSession ss = InitServlet.getSqlSession();

		try {
			int rInt = ss.insert("UserInfo.insertUserList", pUser);
			ss.commit();
			return rInt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return 0;
	}
	
	public int delete(Map<String,String> pUser) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int rInt = ss.delete("UserInfo.delete", pUser);
			ss.commit();
			return rInt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return 0;
	}
	
	

	public static void main(String[] args) {
		UserInfoDAO udao = new UserInfoDAOImpl();
		UserInfoVO pUser = new UserInfoVO();
		pUser.setUiNum(29);
		System.out.println(udao.selectOne(pUser));
	}

	@Override
	public UserInfoVO selectOne(UserInfoVO pUser) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectOne("UserInfo.selectOne", pUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
}
