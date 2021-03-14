<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .errormsg{
 	font-size:  14px;
 	color:red;
 }
</style>
</head>
<body>	
	<c:choose>
		<c:when test="${empty id}">
			<c:if test="${not empty cookie.id}">
				<c:set var="isSave" value="value='${cookie.id.value }'"/>
				<c:set var="checked" value="checked" />
			</c:if>
			<form method="post"  action="login.do">
				<table align="center" border="1">
				    <c:if test="${not empty msg }">
				    	<tr>
				    		<td colspan="2" class="errorMsg">${msg}</td>
				    	</tr>
				    </c:if>
					<tr><td>아 이 디</td>
					<td><input type="text" name="id" ${isSave }></td></tr>
					<tr><td>비밀번호</td>
					<td><input type="password" name="password"></td></tr>
					<tr>
						<td colspan="2"  align="right">
						  아이디 저장<input type="checkbox" name="idsave" value="t" ${checked}/>
						  <input type="submit" value="로그인">
						</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
				${id} 님 환영합니다.
				<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>

</body>
</html>

	





