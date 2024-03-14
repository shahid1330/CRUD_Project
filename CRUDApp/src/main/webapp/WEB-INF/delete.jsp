<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>

</head>
<body>
    <div>
        <h2 >Delete User</h2>
    </div>
    <form action="DeleteForm" method="post">
        Email: <input type="text" name="email1" /><br/><br/>
        Password: <input type="password" name="pass1" /><br/><br/>
        <input type="submit" value="Delete"/>
    </form>
</body>
</html>