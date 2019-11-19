package com.mvn.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.service.impl.UserInfoServiceImpl;
import com.mvn.test.vo.UserInfoVO;

@WebServlet(name = "UserInfoController", urlPatterns = { "/user/*" })
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String cmd = request.getRequestURI().substring(6);
		if("list".equals(cmd)) {
			List<UserInfoVO> uiList = uis.getUserList(null);
			response.getWriter().print(gson.toJson(uiList));
		}else if("view".equals(cmd)) {
			UserInfoVO pUser = new UserInfoVO();
			pUser.setUiNum(Integer.parseInt(request.getParameter("uiNum")));
			UserInfoVO uiVO = uis.selectOne(pUser);
			response.getWriter().print(gson.toJson(uiVO));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String sort = request.getRequestURI();
		sort = sort.substring(6);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		BufferedReader br = request.getReader();
		String str = null;
		String json = "";
		while ((str = br.readLine()) != null) {
			json += str;
		}
		if ("insert".equals(sort)) {
			UserInfoVO pUser = gson.fromJson(json, UserInfoVO.class);
			Map<String, String> result = new HashMap<String, String>();
			if (uis.insertList(pUser) == 1) {
				result.put("msg", "저장 성공");
				pw.print(gson.toJson(result));
			} else {
				result.put("msg", "저장 실패");
				pw.print(gson.toJson(result));
			}
		}else if ("delete".equals(sort)) {
			Map<String, String> pUser = gson.fromJson(json, Map.class);
			Map<String, String> result = new HashMap<String, String>();
//			if (uis.insertList(pUser)==1) {
//				result.put("msg", "삭제 성공");
//				pw.print(gson.toJson(result));
//			} else {
//				result.put("msg", "삭제 실패");
//				pw.print(gson.toJson(result));
//			}
		}
	}

}
