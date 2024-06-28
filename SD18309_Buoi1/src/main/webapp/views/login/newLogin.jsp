<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/login/trangchu" method="get">
    Tài khoản:
    <input type="text" name="tenDangNhap" value="${tk}"><br>
    Mật khẩu:
    <input type="text" name="matKhau" value="${mk}"><br>
    <span style="color: red">${error}</span><br>
    <button>Login</button>
</form>
</body>
</html>