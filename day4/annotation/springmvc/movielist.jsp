<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${mo.get("영화제목1") }  --%>

<form action="moviereserve" method="post">
아이디<input type="text" name="id"><br>
암호<input type="password" name="pw"><br>
나이<input type="number" name="age"><br>

<%
Object mo = request.getAttribute("mo");
HashMap<String, Integer> map = (HashMap<String, Integer>) mo;
for (Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    out.println( key + ","+ value + "<input type=checkbox id="+value+" name='moviemap' value="+key+","+value+"><br>");
}
%>
<input type="submit" value="영화신청">


</form>
</body>
</html>