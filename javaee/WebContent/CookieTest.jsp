<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    //발급된 쿠키 추출
		Cookie[] cookies = request.getCookies(); // 몇개나 될지 모르니까 배열
		if(cookies != null){
			for(Cookie cookie: cookies){
			%>
				<p> 
					쿠키 이름 : <%= cookie.getName() %>
					쿠키 값 : <%= cookie.getValue() %>
				</p>		
			<%
			}
		}
	%>
	<form action="cookietest.do" method="post">
		<table  align="center">
			<tr><td>쿠키이름</td>
			    <td><input type="text" name="cookiename" id="cookiename"/></td>
			</tr>
			<tr><td>쿠키값</td>
			    <td><input type="text" name="cookievalue" id="cookievalue"/></td>
			</tr>
			<tr><td colspan="2" align="right">
			     <input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>



