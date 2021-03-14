<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>     
<%	String greeting="hello,hi,bye,안녕,안녕하세요";
	String price="5000 3000 7000 10000";
	pageContext.setAttribute("greeting", greeting);
	pageContext.setAttribute("price", price);          %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 인사 : 
	<c:forTokens items="${greeting}" delims="," var="g">
		${g }
	</c:forTokens>
	<c:forTokens items="${price}" delims=" " var="p">
		${p }
	</c:forTokens>
	</p>
	
</body>
</html>