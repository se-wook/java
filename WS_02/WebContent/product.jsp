<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!private int no = 0; %>
	
	상품이 저장되었습니다.<br/>
	상품 번호 : <%= ++no %> <br/>
	상품명 : <%= request.getParameter("name") %> <br/>
	상품 가격 : <%= request.getParameter("price") %> <br/>
	상품 설명 : <%= request.getParameter("desc") %> <br/>
	<a href="productRegister.html"> 상품 등록 </a>

</body>
</html>