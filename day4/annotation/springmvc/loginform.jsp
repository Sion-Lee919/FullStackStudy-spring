<%@ page language="java" contentType="text/html; charset=utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${title }</h1>
<h1><%=request.getAttribute("title") %></h1>
<form action="login" method="post">
아이디 <input type="text" name="id"><br>
비번 <input type="password" name="pw"><br>
나이 <input type="text" name="age"><br>
<input type="submit" value="로그인"><br>
</form>
</body>
</html>