<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    response.setContentType("text/html; charset=UTF-8");
%>
${mov.id }<br>
${mov.pw }<br>
${mov.age }<br>

<c:forEach var="item" items="${mov.moviemap}">
    ${item}<br>
</c:forEach>

</body>
</html>