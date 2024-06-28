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
    <form action="/hoa-don/update/${data.id}" method="post">
        <div>
            <label>Nhân viên</label>
            <input type="text" name="idNV" value="${data.idNV}">
            <c:if test="${not empty errors['idNV']}">
                <small style="color: #ff0000">${errors['idNV']}</small>
            </c:if>
        </div>
        <div>
            <label>Khách hàng</label>
            <input type="text" name="idKH" value="${data.idKH}">
            <c:if test="${not empty errors['idKH']}">
                <small style="color: #ff0000">${errors['idKH']}</small>
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
            <select name="trangThai">
                <option value="1" ${data.trangThai ==1 ? "selected" : ""}>Đang hoạt động</option>
                <option value="0" ${data.trangThai ==0 ? "selected" : ""}>Ngừng hoạt động</option>
            </select>
        </div>
        <div>
            <button >Lưu</button>
        </div>
    </form>
</body>
</html>