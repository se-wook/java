<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!  int count =0; %>   
	
	<h1>count : <%= ++count %></h1>
	<% 	
		if(count>5){ 
			//즉각적으로 새로운 JSESSIONID를 발급해서 이전 세션에 접근하지 못하게 -> 이전 세션을 소멸
			session.invalidate();
	
		}
	%>
	
	<h2>JESSIONiD : <%= session.getId() %></h2>
</body>
</html>







