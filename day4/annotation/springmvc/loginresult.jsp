<%@ page language="java" contentType="text/html; charset=utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){alert("보입니다")});
</script>
</head>
<body>
<h3>Model 인터페이스 저장 전달 객체 : ${model2 }</h3>
<h3>ModelMap 저장 전달 객체 : ${model3 }</h3>
<h3>ModelMap 저장 전달 객체 : ${model4 }</h3>
<h3>ModelAndView 저장 전달 객체 : ${model5 }</h3>
<h3>${model.id }회원님 환영합니다.</h3>
${model.pw } 암호
<img src="resources/images/jquery.png">
</body>
</html>