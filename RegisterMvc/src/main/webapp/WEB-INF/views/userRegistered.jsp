<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>
<div align="center">
	<font color="green"><h1>Successfully Registered</h1></font>
	<p>userName: ${msg}, you have successfully registered in.</p>
	<font color="green"><h1>Welcome to Spring world !</h1></font>
	
	<table align="center">
            <tr>
                <td><a href="login">Login</a>
                </td>
                <td><a href="newUser">New User</a>
                </td>
                <td><a href="home">Home</a>
                </td>
            </tr>
        </table>
</div>        
</body>
</html>