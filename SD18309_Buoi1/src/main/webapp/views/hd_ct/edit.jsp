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
<form action="/hd-ct/update/${data.id}" method="post">
    <div>
        <label>ID hóa đơn</label>
        <input type="text" name="idHoaDon" value="${data.idHoaDon}">
        <c:if test="${not empty errors['idHoaDon']}">
            <small style="color: #ff0000">${errors['idHoaDon']}</small>
        </c:if>
    </div>
    <div>
        <label>Id sản phẩm chi tiết</label>
        <input type="text" name="idSPCT" value="${data.idSPCT}">
        <c:if test="${not empty errors['idSPCT']}">
            <small style="color: #ff0000">${errors['idSPCT']}</small>
        </c:if>
    </div>
    <div>
        <label>Số lượng</label>
        <input type="text" name="soLuong" value="${data.soLuong}">
        <c:if test="${not empty errors['soLuong']}">
            <small style="color: #ff0000">${errors['soLuong']}</small>
        </c:if>
    </div>
    <div>
        <label>Đơn giá</label>
        <input type="number" name="donGia" value="${data.donGia}">
        <c:if test="${not empty errors['donGia']}">
            <small style="color: #ff0000">${errors['donGia']}</small>
        </c:if>
    </div>
    <div>
        <label>Trạng thái</label>
        <select name="trangThai">
            <option value="1" ${data.trangThai ==1 ? "selected" : ""}>Đang hoạt động</option>
            <option value="0" ${data.trangThai ==0 ? "selected" : ""}>Ngừng hoạt động</option>
        </select>
    </div>
    <button>Lưu</button>
</form>
</body>
</html>