<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">SMS Application</h3>
<font color="green">${successMsg}</font>
<font color="red">${errorMsg}</font>
<form action="${pageContext.request.contextPath}/sendSms"> 
<table>
<tr>
<td>Mobile Number</td><td>:</td><td><input type="text" name="mobile"/></td>
</tr>
<tr>
<td>Text Message</td><td>:</td><td><textarea rows="5" cols="20" name="message"> </textarea></td>
</tr>
</table>
<input type="submit" value="Send"/>
</form>
</body>
</html>