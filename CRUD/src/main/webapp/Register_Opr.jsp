<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
    <form action="regForm" method="post" style="margin: 0 auto; width: 300px; text-align: center;">
    	<h2>Registration Page</h2>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name1" required/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email1" required/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="pass1" required/></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender1" value="Male" id="male"/><label for="male">Male</label>
                    <input type="radio" name="gender1" value="Female" id="female"/><label for="female">Female</label>
                </td>
            </tr>
            <tr>
                <td>City:</td>
                <td>
                    <select name="city1">
                        <option>Select City</option>
                        <option>Delhi</option>
                        <option>Mumbai</option>
                        <option>Pune</option>
                        <option>Ranchi</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
