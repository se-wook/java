<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.ssafy.model.dto.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	마지막 등록한 상품.<br/>
	상품 번호 : ${cookie.no.value } <br/>
	상품명 : ${cookie.brand.value } <br/>
	상품 가격 : ${cookie.price.value } <br/>
	상품 설명 : ${cookie.info.value } <br/>
	<a href="productRegister.html"> 상품 등록 </a>
	<a href="Login.jsp"> 뒤로 가기</a>
</body>
</html>