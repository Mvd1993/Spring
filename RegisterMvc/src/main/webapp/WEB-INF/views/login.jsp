<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
<form:form name="submitForm" method="POST"  >
<div align="center">
<div style="color: blue">Type your userName and Password</div>

<table>
<tr>
<td><label ></label></td>

</tr>
<tr>
<td><label >User Name</label></td>
<td><input type="text" name="userName" /></td>
</tr>
<tr>
<td><label >Password</label></td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit" /></td>
</tr>
</table>
<div style="color: red">${message}</div>

</div>
</form:form>

</body>
</html>