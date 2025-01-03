<%@page import="annotation.springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
HelloDTO model = (HelloDTO) request.getAttribute("model");

%>
<h3>jsp변수<%=model %></h3>
<h3>el 변수 ${model }</h3>
</body>
</html>