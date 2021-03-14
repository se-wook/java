<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      import ="com.ssafy.model.dto.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.searchdetail {
	display: inline-block;
	float:left
/* 	text-align:center;
 */
 }
</style>

<script>
	
</script>
</head>
<body>
<section class='searchdetail'>
	상품이름 : <input type="text"/></br>
	<button type="submit">검색</button></br>
	<a href="Login.jsp"> 메인페이지로.. </a> </br></br>
</section>
<table align="center" border="1">
	<tr><td width="200">상품이름</td>
        <td width="100">단가</td>
        <td width="180">개수</td>
        <td width="43">버튼</td>
    </tr>  
		<c:choose>
		<c:when test="empty products">
			<tr>
				<td colspan="4">장바구니에 담은 상품이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<jsp:useBean id="products" class="java.util.ArrayList" scope="session"/>
			<% 
				ArrayList<Product> product = products;
				pageContext.setAttribute("products", product);
			%>	
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.name }</td>
					<td>${p.price }</td>
					<td>${p.desc }</td>
					<td>
						<form method="post" action="productDelete.do">
							<input type="hidden" value="1"/>
							<input type="button" value="삭제" onclick=""/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	
	</c:choose>
</table>

</body>
</html>