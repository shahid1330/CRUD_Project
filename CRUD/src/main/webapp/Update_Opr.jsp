<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
    <h2 style="text-align: center;">Update User</h2>
    <form action="UpdateForm" method="post" style="margin: 0 auto; width: 300px; text-align: center;">
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
                <td>New City:</td>
                <td><input type="text" name="city1" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
