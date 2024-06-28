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
    <h2>Quản lý nhân viên</h2>
    <form action="/hoa-don/store" method="post">
        <div>
            <label>Id nhân viên</label>
            <input type="text" name="idNhanVien" value="${data.idNhanVien}">
            <c:if test="${not empty errors['idNhanVien']}">
                <small style="color: #ff0000">${errors['idNhanVien']}</small>
            </c:if>
        </div>
        <div>
            <label>Id Khách Hàng</label>
            <input type="text" name="idKhachHang" value="${data.idKhachHang}">
            <c:if test="${not empty errors['idKhachHang']}">
                <small style="color: #ff0000">${errors['idKhachHang']}</small>
            </c:if>
        </div>
        <div>
            <label>Ngày mua hàng</label>
            <input type="date" name="ngayMuaHang" value="${data.ngayMuaHang}">
            <c:if test="${not empty errors['ngayMuaHang']}">
                <small style="color: #ff0000">${errors['ngayMuaHang']}</small>
            </c:if>
        </div>
        <div>
            <label>Trạng thái</label>
            <select name="trangThai" id="">
                <option value="1">Đang hoạt động</option>
                <option value="0">Ngừng hoạt động</option>
            </select>
        </div>
        <div>
            <button >Lưu</button>
        </div>
    </form>
</body>
</html>