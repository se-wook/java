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
	function deleteProduct(no){
		var frm = document.getElementById("frm");
		var noForm = document.getElementById("no");
		noForm.value = no;
		frm.action = "productDelete.do";
		frm.submit();
	}
	function searchProduct(){
		var frm = document.getElementById("searchForm");
		alert("!");
		frm.action = "productSearch.do";
		frm.submit();
	}
</script>
</head>
<body>
<section class='searchdetail'>
	<form id="searchForm">
		상품이름 : <input type="text" name="prodname" id="prodname"/></br>
		상품가격 : <input type="text" name="prodprice" id="prodprice"/></br>
		<input type="button" onclick="searchProduct()" value="검색"/></br>
	</form>
		<a href="Login.jsp"> 메인페이지로.. </a></br></br>
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
					<td>${p.name} </td>
					<td>${p.price}</td>
					<td>${p.desc} </td>
					<td>
						<form  id="frm">
							<input type="hidden" id="no" name="no" />
							<input type="button" value="삭제" onclick="deleteProduct(${p.no})"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	
	</c:choose>
</table>

</body>
</html>