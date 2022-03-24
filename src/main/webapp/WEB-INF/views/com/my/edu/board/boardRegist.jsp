<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- jquery -->
<script src="/js/jquery-3.6.0.js"></script>
<head>
<meta charset="UTF-8">
<title>게시판등록</title>

<script type="text/javascript">
$(document).ready(function(){
	
});

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

function fnSave() {
    var form = $('#registForm');
      if (confirm("저장하시겠습니까?")) {
    	  
    	  $.ajax({
    	         url : '/board/boardInsert.do'
    	         , type : 'POST'
    	         , data : form.serialize()
    	         , dataType : 'json'
    	         , success : function(response) {
    	             //정상 요청, 응답 시 처리 작업
    	             if (response != null && response.resultCode == "0") { // 성공
    	            	 alert(response.resultMsg);
    	              // 목록으로 이동
    	             	fnCancel();
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

function fnCancel() {
    var form = $('#registForm');
    
    form.attr('action', '/board/boardList.do');
    form.submit();
 }

</script>

</head>
<body>
<form id="registForm" name="registForm" method="post">
<input type="hidden" id="mberId" name="mberId" value="${mberId}" />

	<table>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title" />
				</td>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="50" id="content" name="content" ></textarea>
				</td>
			</tr>
			<tr>
				<th>게시글비밀번호</th>
				<td>
					<input type="password" id="boardPw" name="boardPw" style="background-color: LightGray;" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<th>공개여부</th>
			 	<td>
			 		<input type="radio" id="boardOpenYn_Y" name="boardOpenYn" value="Y" checked="checked" onclick="fnBbsOpenYnChk(this.value);">
                    <label for="boardOpenYn_Y">예</label>
                  	<input type="radio" id="boardOpenYn_N" name="boardOpenYn" value="N" onclick="fnBbsOpenYnChk(this.value);">
                    <label for="boardOpenYn_N">아니오</label>
			 	
			 	</td>
			 </tr>
		</tbody>
	</table>
</form>
</br>
	<button type="button" style="margin-left: 190px;" id="saveBtn" onclick="fnSave()">저장</button>
	<button type="button" style="" id="cancelBtn" onclick="fnCancel();">취소</button>
</body>
</html>