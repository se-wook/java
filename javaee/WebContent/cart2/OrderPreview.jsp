<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.ssafy.model.domain.Goods"%>
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center">
	<tr><td width="200">상품이름</td>
        <td width="100">단가</td>
        <td width="100">개수</td>
        <td width="100">금액</td>
    </tr>   
	<c:choose>
		<c:when test="empty cart">
			<tr>
				<td colspan="4">장바구니에 담은 상품이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<jsp:useBean id="cart" class="java.util.HashMap" scope="session"/>
			<% 
				Collection<Goods> goods = cart.values();
				pageContext.setAttribute("goods", goods);
			%>	
			<c:set var="totalPrice" value="0" />			
			<c:forEach var="g" items="${goods}">
				<tr>
					<td>${g.proname }</td>
					<td>${g.proprice }</td>
					<td>${g.quantity }</td>
					<td>${g.total }</td>
				</tr>
				<c:set var="totalPrice" value="${totalPrice+g.total}" />			
			</c:forEach>
		</c:otherwise>
	
	</c:choose>
  
    <tr><td></td>
    	<td></td> 
    	<td></td> 
    	<td></td> 
    
    <tr><td colspan="3"  align="right">주문한 총 금액</td>
    	<td>${totalPrice }</td>    
    </tr> 
   
    <tr><td colspan='4' align="center"><a href='book.html'>책</a></td></tr>
</table>
</body>




</html>


