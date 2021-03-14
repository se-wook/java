<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.ssafy.model.dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String msg = (String)request.getAttribute("msg");
	
		if(msg != null){
	%>
		<%= msg %>
	<% }else{ 
		Member member = (Member)request.getAttribute("member");
	%>
		아이디 : <%= member.getId() %> <br/>
		패스워드 : <%= member.getPassword() %> <br/>
		이름 : <%= member.getName() %> <br/>
		이메일 : <%= member.getEmail() %> <br/>
		전화번호 : <%= member.getPhone() %> <br/>
		주소 : <%= member.getAddress() %> <br/>
	<% } %>
</body>
</html>