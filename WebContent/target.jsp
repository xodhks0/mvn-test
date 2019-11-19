<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// source를 거치지 않고 온다면 getAttribute는 null
		String name = (String) pageContext.getAttribute("name");
		out.println(name);
		name = (String) request.getAttribute("name");
		out.println(name);
		// request.setAttribute(getAttribute)의 데이터타입은 Object여서 다운캐스팅 해줘야함
		RequestDispatcher rd = request.getRequestDispatcher("/final.jsp");
		rd.forward(request, response);
		// 다시 forward 했을때 같은 request를 보내줌
	%>
</body>
</html>