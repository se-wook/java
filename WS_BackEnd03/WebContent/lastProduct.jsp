<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.ssafy.model.dto.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String no = "";
	String name = "";
	String price = "";
	String desc = "";
	if(cookies != null){
		System.out.println(cookies[1].getName());
		
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("no")){
				no = cookies[i].getValue();
			}
			if(cookies[i].getName().equals("brand")){
				name = cookies[i].getValue();
			}
			if(cookies[i].getName().equals("price")){
				price = cookies[i].getValue();
			}
			if(cookies[i].getName().equals("info")){
				desc = cookies[i].getValue();
			}
		}

%>
	마지막 등록한 상품.<br/>
	상품 번호 : <%= no %> <br/>
	상품명 : <%= name %> <br/>
	상품 가격 : <%= price %> <br/>
	상품 설명 : <%= desc %> <br/>
	<a href="productRegister.html"> 상품 등록 </a>
	<a href="Login.jsp"> 뒤로 가기</a>
<%
	}
%>
</body>
</html>