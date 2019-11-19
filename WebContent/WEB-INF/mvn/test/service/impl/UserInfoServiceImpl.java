package com.mvn.test.service.impl;

import java.util.List;
import java.util.Map;

import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.dao.impl.UserInfoDAOImpl;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();

	@Override
	public List<UserInfoVO> getUserList(Map<String, String> pUser) {
		return uidao.selectUserList(pUser);
	}
	
	public int insertList(UserInfoVO pUser) {
		return uidao.insertList(pUser);
	}

	public int delete(Map<String,String> pUser) {
		return uidao.delete(pUser);
	}

	@Override
	public UserInfoVO selectOne(UserInfoVO pUser) {
		return uidao.selectOne(pUser);
	}
}
