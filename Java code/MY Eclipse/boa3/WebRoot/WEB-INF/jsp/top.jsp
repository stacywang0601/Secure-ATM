<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to use VISA service</title>
</head>
<body>
<h2 align="center">ATM</h2>
<h4 align="center" id="balance"></h4>
<hr>
<table align="center" width="90%" cellpadding="2" cellspacing="2">
	<tr>
		<td><a href="BusinessServlet?op=queryBalance">Check Balances</a></td>
		<td><a href="BusinessServlet?op=deposit">Deposit</a></td>
		<td><a href="BusinessServlet?op=fetch">Withdrawal</a></td>
		<td><a href="BusinessServlet?op=changePwd">Change PIN</a></td>
		<td><a href="BusinessServlet?op=exit">Log out</a></td>
	</tr>
</table>
</body>

</html>