<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <form action="LoginForm" method="post" style="margin: 0 auto; width: 300px; text-align: center;">
    <h2>Login Page</h2>
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email1" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="pass1" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;"><input type="submit" value="Login" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
