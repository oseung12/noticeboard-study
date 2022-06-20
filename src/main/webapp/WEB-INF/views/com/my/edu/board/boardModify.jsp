<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- jquery -->
<script src="/js/jquery-3.6.0.js"></script>
<head>
<title>게시판수정</title>

<script type="text/javascript">
$(document).ready(function(){
	
});

function fnDetail() {
    
    var form = $('#modifyForm');
    
    form.attr('action', '/board/boardDetail.do');
    form.submit();
 }

function fnModify() {
	
	var form = $('#modifyForm');
	
  if (confirm("수정하시겠습니까?")) {
    	  
    	  $.ajax({
    	         url : '/board/boardUpdate.do'
    	         , type : 'POST'
    	         , data : form.serialize()
    	         , dataType : 'json'
    	         , success : function(response) {
    	             //정상 요청, 응답 시 처리 작업
    	             if (response.resultCode == "0") { // 성공
    	            	 alert(response.resultMsg);
    	              // 상세로 이동
    	             	fnDetail();
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


function fnBbsOpenYnChk(val) {
	$('#boardPw').val("");
	if(val== "Y"){
		$('#boardPw').css("background", "LightGray");
		$('#boardPw').attr("readonly", true);
		$('#boardOpenYn_Y').prop("checked", true);
		$('#boardOpenYn_N').prop("checked", false);
	}else {
		$('#boardPw').css("background", "white");
		$('#boardPw').attr("readonly", false);
		$('#boardOpenYn_Y').prop("checked", false);
		$('#boardOpenYn_N').prop("checked", true);		
	}
}

</script>

</head>
<body>
<form id="modifyForm" name="detailForm" method="post">
<input type="hidden" id="mberId" name="mberId" value="${mberId}" />
<input type="hidden" id="boardNo" name="boardNo" value="${boardVO.boardNo}" />

	<table>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title" value="${boardVO.title}"/>
				</td>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="50" id="content" name="content">${boardVO.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>게시글비밀번호</th>
				<td>
					<input type="password" id="boardPw" name="boardPw" value="${boardVO.boardPw}" <c:if test="${boardVO.boardOpenYn eq 'Y'}">style="background-color: LightGray;"</c:if> <c:if test="${boardVO.boardOpenYn eq 'N'}"> readonly="readonly" </c:if> />
				</td>
				</td>
			</tr>
			<tr>
				<th>공개여부</th>
			 	<td>
			 		<input type="radio" id="boardOpenYn_Y" name="boardOpenYn" value="Y" <c:if test="${boardVO.boardOpenYn eq 'Y'}">checked="checked"</c:if> onclick="fnBbsOpenYnChk(this.value);">
                    <label for="boardOpenYn_Y">예</label>
                  	<input type="radio" id="boardOpenYn_N" name="boardOpenYn" value="N" <c:if test="${boardVO.boardOpenYn eq 'N'}">checked="checked"</c:if> onclick="fnBbsOpenYnChk(this.value);">
                    <label for="boardOpenYn_N">아니오</label>
			 	</td>
			 </tr>
		</tbody>
	</table>
</form>
</br>
	<button type="button" style=""  onclick="fnModify();">수정</button>
	<button type="button" style=""  onclick="fnDetail();">취소</button>
</body>
</html>
