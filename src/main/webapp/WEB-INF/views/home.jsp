<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<!-- jquery -->
<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"></script> -->
<script src="/js/jquery-3.6.0.js"></script>
<head>
	<title>메인페이지</title>
</head>
<body>
<div class="loginForm">
      <form id="mberForm" name="mberForm" method="post">
         <table class="memberTable">
            <colgroup>
               <col width="50%">
               <col width="50%">
            </colgroup>
            <tbody>
               <tr>
                  <th>아이디</th>
                  <td>
                     <input type="text" id="mberId" name="mberId" value="" />
                  </td>
               </tr>
               <tr>
                  <th>비밀번호</th>
                  <td>
                     <input type="password" id="mberPw" name="mberPw" value="" />
                  </td>
               </tr>
            </tbody>
         </table>
      </form>
      
      <button type="button" class="loginBtn" style="margin-left: 230px;" id="mberLoginBtn" onclick="fnMberConfirm();">로그인</button>
      <button type="button" class="loginBtn" style="" id="mberJoinBtn" onclick="fnMberJoin();">회원가입</button>
   </div>
</body>
</html>

