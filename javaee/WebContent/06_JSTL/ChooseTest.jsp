<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<% pageContext.setAttribute("name","ssafy");
		pageContext.setAttribute("escape", "<ssafy>");
		
		
	%>
	<c:out value="${name }"/>
	<c:out value="${escape}" escapeXml="true"/> --%>
	
	<c:choose>
		<c:when test="${param.user =='member' }">
			<c:import url="../Login.jsp"></c:import>	
		</c:when>
		<c:when test="${param.user =='guest' }">
			<jsp:include page="../memberRegister.html"/>
		</c:when>
		<c:otherwise>
			<p> 잘못 입력했습니다. 다시 입력하세요.</p>	
		</c:otherwise>
	</c:choose>
	<a href="ChooseTest.html">다시 입력하기.</a>
	
</body>
</html>








