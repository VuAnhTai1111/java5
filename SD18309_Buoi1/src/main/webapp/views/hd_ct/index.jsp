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
<form action="/hd-ct/searchIdHD" method="get">
    Sản phẩm:
    <select name="idHoaDon" id="">
        <c:forEach items="${dataHD}" var="sp">
            <option value="${sp.id}">${sp.id}</option>
        </c:forEach>
    </select>
    <button>Tìm</button>
</form>
<form action="/hd-ct/searchIdSPCT" method="get">
    Sản phẩm:
    <select name="idSPCT" id="">
        <c:forEach items="${dataSPCT}" var="sp">
            <option value="${sp.id}">${sp.id}</option>
        </c:forEach>
    </select>
    <button>Tìm</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>Id hóa đơn chi tiết</th>
        <th>Id hóa đơn</th>
        <th>Id sản phẩm chi tiết</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="ct">
        <tr>
        <td>${ct.id}</td>
        <td>${ct.idHoaDon}</td>
        <td>${ct.idSPCT}</td>
        <td>${ct.soLuong}</td>
        <td>${ct.donGia}</td>
        <td>${ct.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
        <td><a href="/hd-ct/edit/${ct.id}">Update</a></td>
<%--        <td><a href="/hd-ct/delete/${ct.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
<%--    <tr>--%>
<%--        <td>1</td>--%>
<%--        <td>SPCT01</td>--%>
<%--        <td>Đỏ</td>--%>
<%--        <td>X</td>--%>
<%--        <td>100</td>--%>
<%--        <td>250000</td>--%>
<%--        <td>Đang Hoạt động</td>--%>
<%--        <td><a href="">Update</a></td>--%>
<%--        <td><a href="">Delete</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>2</td>--%>
<%--        <td>SPCT02</td>--%>
<%--        <td>Vàng</td>--%>
<%--        <td>XL</td>--%>
<%--        <td>25</td>--%>
<%--        <td>100000</td>--%>
<%--        <td>Ngừng Hoạt động</td>--%>
<%--        <td><a href="">Update</a></td>--%>
<%--        <td><a href="">Delete</a></td>--%>
<%--    </tr>--%>
    </tbody>
</table>
</body>
</html>