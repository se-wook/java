<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type='text/javascript' src='js/jquery-3.3.1.js'></script>

<script>

$(function(){
	$('#login').click(function(e){
		var id = $('#id').val();
		var pw = $('#pw').val();
		if(id != "" && pw != ""){
			return true;
		}
		return false;
	})
})

</script>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String id="";
	String checked="";
	if(cookies!=null){
		for(Cookie cookie: cookies){
			if(cookie.getName().equals("id")){
				id = cookie.getValue();
				checked="checked='checked'";
			}
		}
	}
	%>	
	<form method="post"  action="sessionlogin.do">
	<table align="center" border="1">
	    
		<tr><td>아 이 디</td>
		<td><input type="text" name="id" id="id" value="<%=id%>"></td></tr>
		<tr><td>비밀번호</td>
		<td><input type="password" name="password" id="pw"></td></tr>
		<tr>
			<td colspan="1"  align="right">
			  <input type="submit" value="로그인" id="login">
			</td>
		</tr>
	</table>
</form>
</body>
</html>

	





