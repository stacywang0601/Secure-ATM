<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to use VISA service</title>
</head>
<body>
<h2 align="center"> ATM </h2>
<hr>
<font color="red">${message}</font>
<form action="loginservlet" method="post">
	<table align="center" width="90%" cellpadding="2" cellspacing="2">
		<tr><td align="center">USR：<input type="text" name="cardnum">	</td></tr>
		<tr><td align="center">PIN：  <input type="password" name="pwd"></td></tr>
		<tr><td align="center"><font color="red"></font></td></tr>
		<tr><td align="center"><input type="submit" value="Log In"></td></tr>
	</table>
</form>
</body>
</html>
