<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="https://pagination.js.org/dist/2.1.4/pagination.css">
<style>
	.boardSub{
		display:none;
	}
	.boardView{
		display:block;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#search").click(function(){
			pagelist(1);
		})
		<c:if test="${!empty param.key}">
			$("#key").val("${param.key}");
		</c:if>
		$("#word").val("${param.word}");
		$("#pageNumber").val("${param.pageNumber}");
		$('.boardContent').hover(getContent, function(){
			$('div',this).addClass('boardSub').removeClass('boardView');
		})
	})
	
	
	function getContent(){
		$('div',this).addClass('boardView').removeClass('boardSub');
		var boardNo = $('div',this).attr('data-no');
		var thisContent = $(this);
		//$('div',this).text('hello');
		$.ajax({
			url: 'searchBoardAjax.do',
			data: { no : $('div',thisContent).attr('data-no') },
			dataType :'json',
			success: function(data){
				$('div',thisContent).text(data.contents);
			},
			error : function(err){
				console.log(err)
			}
			
		})
	}
	
	function searchBoard(no){
		var frm = document.getElementById("frm");
		var noForm = document.getElementById("no");
		noForm.value = no;
		frm.action = "searchBoard.do";	
		
		frm.submit();
	}
	function pagelist(cpage){
		var frm = document.getElementById("frm");
		var pageNo = document.getElementById("pageNumber");
		pageNo.value = cpage;
		frm.action = "listBoard.do";
		
		frm.submit();		
	}
</script>

</head>
<body>
	<jsp:include page="/title.jsp" />
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<div class="main">
				<form id="frm">
					<input type="hidden" id="no" name="no" />
					<table border="1">
						<tr>
							<th colspan="4">게시글 목록</th>
						</tr>
						<tr align="center">
							<td colspan="4" align="right">
								<select name="key" id="key">
									<option value="all">---선택하세요---</option>
									<option value="id">아이디</option>
									<option value="title">제목</option>
									<option value="contents">내용</option>
								</select>
								<input type="text" id="word" name="word" />
								<input type="hidden" id="pageNumber" name="pageNumber" />
								<input type="button" value="검색" id="search">
								<c:if test="${not empty id }">
									<a href="insertBoardForm.log">글쓰기</a>
								</c:if>
							</td>
						</tr>
						<tr align="center">
							<td width="50">번 호</td>
							<td width="150">제 목</td>
							<td width="50">아이디</td>
							<td width="100">게시일</td>
						</tr>
						<tbody id="data-container">
							<c:forEach var="board" items="${list}">
								<tr>
									<td width="50"><a href="javascript:searchBoard(${board.no})">${board.no}</a></td>
									<td width="150" class='boardContent'>
										<a href="javascript:searchBoard(${board.no})">${board.title}</a>
										<div class='boardSub' data-no = "${board.no}"></div>
									</td>
									<td width="50">${board.id}</a></td>
									<td width="100">${board.regdate}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
			<div id="pagination-container">${bean.pageLink }</div>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://pagination.js.org/dist/2.1.4/pagination.min.js"></script>
<!-- <!-- TODO: 12 http://pagination.js.org/index.html를 참조해서 pagination을 구성하시오.
	// @@ 전달받은 파라미터(key, word, pageNumber)로 검색 조건을 초기화 한다.
	// @@ pagination 부분을 find() 로 작성하시오. 이때 pageNumber가 있다면 해당 page로 이동한다.
	// @@ ajax처럼 동적으로 데이터를 가져오는 경우 pagination.js는 한번 datasource를 구성해야 페이지 이동이 가능하다.
	// @@ 실제 게시물을 조회하기 위해 listBoardData.do 페이지를 이용한다.
	// @@ 게시물의 상세 내용을 확인하기 위해 searchBoard.do를 호출한다.
	// @@ 상세 내용 조회 시 다시 list로 돌아올 때를 대비해서 글번호와 함께 현재 검색 조건을 함께 전달한다.
	// @@ search 버튼 클릭 시 find 함수를 호출한다.
	// @@ 처음 1회는 바로 실행
END: -->
</html>












