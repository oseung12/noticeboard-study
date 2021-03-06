<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<style>

table, td, th {
    border: 1px solid black;
}
 
th {
    background: #F3F5F5;
}
 
table {
    margin-top: 5%;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    width: 80%;
}
 
a:link {
    color: red;
    text-decoration: none;
    cursor: pointer;
}
 
a:visited {
    color: black;
    text-decoration: none;
}
 
/* paginate */
.paginate {
    padding: 0;
    line-height: normal;
    text-align: center;
    position: relative;
    margin: 20px 0 20px 0;
    z-index: 1;
}
 
.paginate .paging {
    text-align: center;
}
 
.paginate .paging a, .paginate .paging strong {
    margin: 0;
    padding: 0;
    width: 20px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    color: #848484;
    display: inline-block;
    vertical-align: middle;
    text-align: center;
    font-size: 12px;
}
 
.paginate .paging a:hover, .paginate .paging strong {
    color: #DAA520;
    font-weight: 600;
    font-weight: normal;
}
 
.paginate .paging .direction {
    z-index: 3;
    vertical-align: middle;
    background-color: none;
    margin: 0 2px;
    border: 1px solid #777;
    border-radius: 2px;
    width: 28px;
}
 
.paginate .paging .direction:hover {
    border: 1px solid #C40639;
}
 
.paginate .paging .direction.prev {
    margin-right: 4px;
}
 
.paginate .paging .direction.next {
    margin-left: 4px;
    cursor: pointer;
}
 
.paginate .paging img {
    vertical-align: middle;
}
 
.paginate .right {
    position: absolute;
    top: 0;
    right: 0;
}
 
.bottom-left, .bottom-right {
    position: relative;
    z-index: 5;
}
 
.paginate ~ .bottom {
    margin-top: -50px;
}
 
.bottom select {
    background: transparent;
    /* color: #aaa; */
    cursor: pointer;
}
 
/* paginate */
.paginate {
    padding: 0;
    line-height: normal;
    text-align: center;
    position: relative;
    margin: 20px 0 20px 0;
}
 
.paginate .paging {
    text-align: center;
}
 
.paginate .paging a, .paginate .paging strong {
    margin: 0;
    padding: 0;
    width: 20px;
    height: 28px;
    line-height: 28px;
    text-align: center;
    color: #999;
    display: inline-block;
    vertical-align: middle;
    text-align: center;
    font-size: 14px;
}
 
.paginate .paging a:hover, .paginate .paging strong {
    color: #C40639;
    font-weight: 600;
    font-weight: normal;
}
 
.paginate .paging .direction {
    z-index: 3;
    vertical-align: middle;
    background-color: none;
    margin: 0 2px;
}
 
.paginate .paging .direction:hover {
    background-color: transparent;
}
 
.paginate .paging .direction.prev {
    margin-right: 4px;
}
 
.paginate .paging .direction.next {
    margin-left: 4px;
}
 
.paginate .paging img {
    vertical-align: middle;
}
 
.paginate .right {
    position: absolute;
    top: 0;
    right: 0;
}
</style>

<!-- jquery -->
<script src="/js/jquery-3.6.0.js"></script>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>

<script type="text/javascript">
$(document).ready(function(){

});

// 게시글 상세
function fnBbsDetail(no,openYn){
    var form = $('#listForm');
    $('#boardNo').val(no);
    $('#boardOpenYn').val(openYn);
    $('#boardPw').val('');
    
    $.ajax({
        url : '/board/boardDetailInfo.do'
        , type : 'POST'
        , data : form.serialize()
        , dataType : 'json'
        , success : function(response) {
        	 console.log(response);
            //정상 요청, 응답 시 처리 작업
            if (response.resultCode == "0") { // 성공
	          if(response.boardVO.boardOpenYn == 'N') { // 게시글 비공개
	        	  $('#boardOpenYn').val('N');
	          	  $('#bbsPwDiv').show();
	          	  
	          }else{ // 게시글 공개
	        	  $('#boardOpenYn').val('Y');
	        	  $('#bbsPwDiv').hide();
	        	  $.ajax({
	        	        url : '/board/boardHitsModify.do'
	        	        , type : 'POST'
	        	        , data : form.serialize()
	        	        , dataType : 'json'
	        	        , success : function(response2) {
	        	        	 console.log(response2);
	        	            //정상 요청, 응답 시 처리 작업
	        	            if (response2.resultCode == "0") { // 성공
	        	                form.attr('action', '/board/boardDetail.do');
	        	                form.submit();
	        	               
	        	            } 
	        	          
	        	        }
	        	        , error : function(request2, status2, error2) {
	        	            //오류 발생 시 처리
	        	           console.log('Ajax 통신 에러');
	        	        }
	        	     });
	          }
                
            } 
          
        }
        , error : function(request, status, error) {
            //오류 발생 시 처리
           console.log('Ajax 통신 에러');
        }
     }); 
}

function fnBbsPwChk(){
	var form =$('#listForm');
	
	 if ($('#boardPw').val() == '' || $('#boardPw').val() == null) {
         alert('게시글 비밀번호를 입력해주세요.');
         return;
      }
	 
	 var params = {
			 'boardNo' : $('#boardNo').val()
	 }
	    $.ajax({
	        url : '/board/boardDetailInfo.do'
	        , type : 'POST'
	        , data : params
	        , dataType : 'json'
	        , success : function(response) {
	        	 console.log(response);
	            //정상 요청, 응답 시 처리 작업
	            if (response.resultCode == "0") { // 성공
		          if(response.boardVO.boardPw == $('#boardPw').val()) { // 입력된 게시글 비밀번호와 등록된 게시글 비밀번호가 같으면.
		        	  //TODO : 조회수 증가 및 상세페이지 이동
		        	    $.ajax({
		        	        url : '/board/boardHitsModify.do'
		        	        , type : 'POST'
		        	        , data : params
		        	        , dataType : 'json'
		        	        , success : function(response2) {
		        	        	 console.log(response2);
		        	            //정상 요청, 응답 시 처리 작업
		        	            if (response2.resultCode == "0") { // 성공
		        	                form.attr('action', '/board/boardDetail.do');
		        	                form.submit();
		        	                
		        	            } 
		        	          
		        	        }
		        	        , error : function(request2, status2, error2) {
		        	            //오류 발생 시 처리
		        	           console.log('Ajax 통신 에러');
		        	        }
		        	     });

		          	  
		          }else{ // 입력된 게시글 비밀번호와 등록된 게시글 비밀번호가 같으면.
		        	alert('게시글 비밀번호가 일치하지않습니다.\n 다시입력해주세요.');
		        	$('#boardPw').focus();
		            return;
		          }
	                
	            } 
	          
	        }
	        , error : function(request, status, error) {
	            //오류 발생 시 처리
	           console.log('Ajax 통신 에러');
	        }
	     }); 
}


// 게시글 등록
function fnBbsRegist(){
    var form = $('#listForm');
    
    form.attr('action', '/board/boardRegist.do');
    form.submit();
}

function movePage(currentPage, cntPerPage, pageSize) {
	var form = $('#pagingForm');
	
	$('#currentPage').val(currentPage);
	$('#cntPerPage').val(cntPerPage);
	$('#pageSize').val(pageSize);
	
	form.attr('action', '/board/boardList.do');
	form.submit();
}

function changeSelectBox(currentPage, cntPerPage, pageSize) {
	var seletcValue = $('#cntSelectBox option:selected').val();
	
	movePage(currentPage, seletcValue, pageSize);
}

function fnLogOut(){
	var form = $('#listForm');
	
	form.attr('action', '/logout.do');
	form.submit();
}

function fnmberList(){
	var form = $('#listForm');
	
	form.attr('action', '/mber/mberList.do');
	form.submit();
}


</script>

</head>
<body>
<button type="button" style="float:right; margin-right: 170px;" onclick="fnLogOut();">로그아웃</button>
<button type="button" style="float:right; margin-right: 20px;" onclick="fnmberList();">회원목록</button>
<h2 style="text-align:center;">게시판</h2>

<form id="listForm" name="listForm" method="post">
<input type="hidden" id="mberId" name="mberId" value="${mberId}" />
<input type="hidden" id="boardNo" name="boardNo" />
<input type="hidden" id="boardOpenYn" name="boardOpenYn" />

	<table>
		<tbody>
			<th>번호</th>
			<th>제목</th>
			<th>공개여부</th>
			<th>조회수</th>
			<th>등록자</th>
			<th>등록일시</th>
			<c:forEach var="item" items="${resultList}" varStatus="i">
			<tr>
				<td>${item.rnum}</td>
				<td>
					<a href="javascript:void(0)" onclick="fnBbsDetail('${item.boardNo}','${item.boardOpenYn}');">${item.title}</a>
				</td>
				<td>${item.boardOpenYn}</td>
				<td>${item.hits}</td>
				<td>${item.name}</td>
				<td>${item.regDate}</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
</form>

<form id="pagingForm" name="pagingForm" method="post">
      <input type="hidden" id="currentPage" name="currentPage" value="" />
      <input type="hidden" id="cntPerPage" name="cntPerPage" value="" />
      <input type="hidden" id="pageSize" name="pageSize" value="" />
   </form>
   
   <!--paginate -->
    <div class="paginate">
        <div class="paging">
            <a class="direction prev" href="javascript:void(0);" onclick="movePage(1,${pagination.cntPerPage},${pagination.pageSize});">&lt;&lt; </a> 
            <a class="direction prev" href="javascript:void(0);" onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasPreviousPage == true}">-1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">&lt; </a>
 
           <c:forEach var="idx" begin="${pagination.firstPage}" end="${pagination.lastPage}">
                <a style="color:<c:out value="${pagination.currentPage == idx ? '#cc0000; font-weight:700; margin-bottom: 2px;' : ''}"/> " href="javascript:void(0);" onclick="movePage(${idx},${pagination.cntPerPage},${pagination.pageSize});">
                   <c:out value="${idx}" />
                </a>
            </c:forEach>
            <a class="direction next" href="javascript:void(0);" onclick="movePage(${pagination.currentPage}<c:if test="${pagination.hasNextPage == true}">+1</c:if>,${pagination.cntPerPage},${pagination.pageSize});">&gt; </a> 
            <a class="direction next" href="javascript:void(0);" onclick="movePage(${pagination.totalRecordCount},'${pagination.cntPerPage},${pagination.pageSize});">&gt;&gt; </a>
        </div>
    </div>
    <!-- /paginate -->
    
    <div class="bottom">
        <div class="bottom-left" style="margin-left: 1280px; margin-top: 50px;">
            <select id="cntSelectBox" name="cntSelectBox" onchange="changeSelectBox(${pagination.currentPage},${pagination.cntPerPage},${pagination.pageSize});" class="form-control" style="width: 100px;">
                <option value="10" <c:if test="${pagination.cntPerPage == '10'}">selected</c:if>>10개씩</option>
                <option value="20" <c:if test="${pagination.cntPerPage == '20'}">selected</c:if>>20개씩</option>
                <option value="30" <c:if test="${pagination.cntPerPage == '30'}">selected</c:if>>30개씩</option>
            </select>
        </div>
    </div>

</br>
<button type="button" id="bbsRegistBtn" style="float: right; margin-right: 180px;" onclick="fnBbsRegist();">등록</button>
</br>
</br>
<div id="bbsPwDiv" style="display: none;">
	<table>
		<tbody>
			<th>게시글 비밀번호</th>
			<tr>
				<td>
				<input type="password" id="boardPw" name="boardPw" />
				<button type="button" onclick="fnBbsPwChk();">확인</button>
				</td>
				
			</tr>			
		</tbody>
	</table>
</div>

</body>
</html>
