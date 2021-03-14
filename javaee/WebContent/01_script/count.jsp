<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!  //선언부:  속성이나 메서드를 선언할 수 있다.  
    private int count = 0;
	public void test(){
		System.out.println("test 함수가 수행됨...");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	<%--서비스 메서드의 바디에 추가가 됩니다. --%>
	<% 
		int local = 0; //local 변수 
		test();
		if(count > 10){ 
	%>
			경축!
	<%		
		}
	%>

	 방문자 수 : <%= ++count %></p>
	 local: <%= ++local %>
</body>
</html>