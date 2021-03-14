<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
<!-- pageContext 에 goods이름으로 객체가 저장되어 있다면 추출,
	없으면 생성해서 pageContext에 저장한다. -->
<jsp:useBean id="goods" class ="com.ssafy.model.domain.Goods" scope="page"/>
<!-- 특정 scope에 저장된 객체의 속성 값을 변경
	target : 특정 scope 에 저장된 객체
	property : 변경할 속성
	value : 변경할 값
  -->
<c:set target="${goods }" property="proname" value="흑당 버블티"></c:set>
<c:set target="${goods }" property="quantity" value="300"></c:set>
	상품이름 : ${goods.proname} <br/>
	상품수량 : ${goods.quantity}<br/>
<!-- 특정 scope 에 데이터(기본 타입과, 문자열) 를 추가 
	var: 저장할 name
	value : 저장할 value

-->
<c:set var="total" value="0"/>
<c:set var="price" value="5000,3000,2000,1000"/>
	<c:forEach var="p" items="${price}"> 
		<!-- 아래 p 태그가 price.length 만큼 실행됨. -->
		<p>
			단가 :${p} 가격 : ${goods.quantity*p}
			<c:set var="total" value="${total+goods.quantity*p}"></c:set>
		</p>
	</c:forEach>
	총 가격 : ${total}
</body>
</html>