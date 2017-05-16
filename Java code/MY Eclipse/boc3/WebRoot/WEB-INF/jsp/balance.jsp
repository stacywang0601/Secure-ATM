<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to use VISA service</title>
</head>
<body>
	<jsp:include page="top.jsp"/>
	<br>

		<input type="hidden" name="op" value="fetch">
		<table align="center" width="90%" cellpadding="2" cellspacing="2">
			<tr><td align="center">Your remaining balance is</td></tr>
			<tr><td align="center"> </td></tr>
			<tr><td align="center">${cardnum }</td></tr>
		</table>

</body>
</html>