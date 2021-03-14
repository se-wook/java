<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- include : 한글이 안깨지고, 변수를 쓸수도 있고, url  패턴을 쓸수도 있다. -->
	<% String url = "../Login.jsp"; %>
	<table>
		<tr><td>html</td>
			<td><jsp:include page = "../FileUpload.html"/></td>
		</tr>
		<tr><td>jsp</td>
			<!-- include 할 페이지를 변수를 통해 출력할 수 있다. include 는 한글 깨짐-->
			<td><jsp:include page = "<%= url%>"/></td>
		</tr>
		<tr><td>servlet</td>
		 	<!--  url 패턴으로도 이동이 가능하다 (해당페이지를 include할 수 있다.) -->
			<td> <jsp:include page="/hello.do" /> </td>
		</tr>
	</table>	
</body>
</html>







