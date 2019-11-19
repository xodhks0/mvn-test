<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	final
	<ul>
		<c:forEach items="${list}" var="name">
			<li>${name}</li>
		</c:forEach>
	</ul>
	<%
		// target.jsp로 왔을경우 보이지않음
		// session으로 왔을경우는 보임
	%>
</body>
</html>