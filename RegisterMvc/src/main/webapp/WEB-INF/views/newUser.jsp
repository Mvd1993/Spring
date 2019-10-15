<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
        <div align="center">
		<div style="color: blue">Type your data</div></div>
            <form:form name="submitForm" method="POST"  >
                <table align="center">
                    <tr>
                        <td>
                            <label path="username">Username</label>
                        </td>
                        <td>
                            <input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label path="password">Password</label>
                        </td>
                        <td>
                            <input type="password" path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label path="firstname">FirstName</label>
                        </td>
                        <td>
                            <input path="firstname" name="firstname" id="firstname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label path="lastname">LastName</label>
                        </td>
                        <td>
                            <input path="lastname" name="lastname" id="lastname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label path="email">Email</label>
                        </td>
                        <td>
                            <input path="email" name="email" id="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label path="address">Address</label>
                        </td>
                        <td>
                            <input path="address" name="address" id="address" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td>
                           <td><input type="submit" value="Submit" /></td>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>