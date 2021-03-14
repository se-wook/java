<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.user =='member' }">
		<c:import url="../Login.jsp"></c:import>	
	</c:if>
	<c:if test="${param.user =='guest' }">
		<c:import url="../memberRegister.html"></c:import>	
	</c:if>
	<c:if test="${param.user != 'member' and param.user != 'guest'}">
		<p> 잘못 입력했습니다. 다시 입력하세요.</p>	
	</c:if>
</body>
</html>