<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="name" value="page" />
<c:set var="name" value="req" scope="request" />
<%
	//pageContext.setAttribute("name", "page");
	//request.setAttribute("name","req");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	source
	<%
	/*
	List<String> strlist = new ArrayList<>();
	strlist.add("홍길동");
	strlist.add("김길동");
	strlist.add("이길동");
	strlist.add("박길동");
	request.setAttribute("list",strlist);
	*/
	// setAttribute(String name, Object o)라서 리스트도 담을수 있음
	RequestDispatcher rd = request.getRequestDispatcher("/target");
	rd.forward(request, response);
	// source.jsp에 내용을 써도 "/target.jsp"로 넘기기 때문에 화면에 보이지않음(그래도 39번라인까지 실행함)
	// "/target"로 넘어가면 url을 호출받는 Target.java로 넘어감
	// Attribute와 Parameter는 저장공간은 다르지만 request로 똑같이 넘어감
%>
</body>
<script>
	
</script>
</html>
<%
	String str = "abc";
	System.out.println(str);
%>