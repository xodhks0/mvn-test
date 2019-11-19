package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.UserInfoVO;

public interface UserInfoService {
	public List<UserInfoVO> getUserList(Map<String,String> pUser);
	
	public int insertList(UserInfoVO pUser);
	
	public int delete(Map<String,String> pUser);
	
	public UserInfoVO selectOne(UserInfoVO pUser);
}
