<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- jquery -->
<script src="/js/jquery-3.6.0.js"></script>
<head>
<title>게시판상세</title>

<script type="text/javascript">
$(document).ready(function(){
	
});

function fnList() {
    
    var form = $('#detailForm');
    
    form.attr('action', '/board/boardList.do');
    form.submit();
 }

function fnDelete() {
	
	var form = $('#detailForm');
	
  if (confirm("삭제하시겠습니까?")) {
    	  
    	  $.ajax({
    	         url : '/board/boardDelete.do'
    	         , type : 'POST'
    	         , data : form.serialize()
    	         , dataType : 'json'
    	         , success : function(response) {
    	             //정상 요청, 응답 시 처리 작업
    	             if (response.resultCode == "0") { // 성공
    	            	 alert(response.resultMsg);
    	              // 목록으로 이동
    	             	fnList();
    	             } else { // 실패
    	                alert(response.resultMsg);
    	                return;
    	             }
    	         }
    	         , error : function(request, status, error) {
    	             //오류 발생 시 처리
    	            console.log('Ajax 통신 에러');
    	         }
    	      });  
      }else {
    	  return;
      }
}


function fnModify() {
	   var form = $('#detailForm');
	    
	    form.attr('action', '/board/boardModify.do');
	    form.submit();
}

</script>

</head>
<body>
<form id="detailForm" name="detailForm" method="post">
<input type="hidden" id="mberId" name="mberId" value="${mberId}" />
<input type="hidden" id="boardNo" name="boardNo" value="${boardVO.boardNo}" />

	<table>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title" value="${boardVO.title}" style="background-color: LightGray;" readonly="readonly" />
				</td>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="50" id="content" name="content" style="background-color: LightGray;" readonly="readonly">${boardVO.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>게시글비밀번호</th>
				<td>
					<input type="password" id="boardPw" name="boardPw" style="background-color: LightGray;" readonly="readonly" value="${boardVO.boardPw}" />
				</td>
			</tr>
			<tr>
				<th>공개여부</th>
			 	<td>
			 		<input type="radio" id="boardOpenYn_Y" name="boardOpenYn" value="Y" <c:if test="${boardVO.boardOpenYn eq 'Y'}">checked="checked"</c:if> disabled="disabled" />
                    <label for="boardOpenYn_Y">예</label>
                  	<input type="radio" id="boardOpenYn_N" name="boardOpenYn" value="N" <c:if test="${boardVO.boardOpenYn eq 'N'}">checked="checked"</c:if> disabled="disabled" />
                    <label for="boardOpenYn_N">아니오</label>
			 	
			 	</td>
			 </tr>
			 <tr>
				<th>등록일시</th>
				<td>
				 <span>${boardVO.regDate}</span>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</br>
	<button type="button" style="margin-left: 190px;" id="saveBtn" onclick="fnList();">목록</button>
	<c:if test="${boardVO.regId eq mberId  or 'ADMIN' eq mberId}">
	<button type="button" style="" id="cancelBtn" onclick="fnModify();">수정</button>
	<button type="button" style="" id="deleteBtn" onclick="fnDelete();">삭제</button>
	 </c:if>
</body>
</html>