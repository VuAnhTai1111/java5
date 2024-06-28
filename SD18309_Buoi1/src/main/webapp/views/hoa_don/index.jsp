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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>Document</title>
</head>
<body class="container">
<form action="/hoa-don/searchIdNV" method="get">
    Nhân viên:
    <select name="idNhanVien">
        <c:forEach items="${dataNV}" var="sp">
            <option value="${sp.id}">${sp.ten}</option>
        </c:forEach>
    </select>
    <button>Tìm</button>
</form>
<form action="/hoa-don/searchIdKH" method="get">
    Khách hàng:
    <select name="idKhachHang">
        <c:forEach items="${dataKH}" var="sp">
            <option value="${sp.id}">${sp.ten}</option>
        </c:forEach>
    </select>
    <button>Tìm</button>
</form>

<form action="/hoa-don/searchNgay" method="get">
    Ngày bắt đầu:
    <input type="date" name="tu">
    Ngày kết thúc:
    <input type="date" name="den">
    <button>Tìm</button>
</form>
<hr>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>idNhanVien</th>
        <th>idKhachHang</th>
        <th>ngayMuaHang</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="hd">
        <tr>
            <td>${hd.id}</td>
            <td>${hd.idNV}</td>
            <td>${hd.idKH}</td>
            <td>${hd.ngayMuaHang}</td>
            <td>${hd.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td><a href="/hoa-don/edit/${hd.id}">Update</a></td>
<%--            <td><a href="/hoa-don/delete/${hd.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>

</table>
<nav aria-label="Page navigation example" style="margin-left: 30%">
    <ul class="pagination">
        <li class="page-item" aria-disabled="true">
                <a class="page-link" href="/hoa-don/index?keyword=${keyword}&&page=${data.number - 1}">Previous</a>

        </li>
        <c:forEach begin="0" end="${ data.totalPages }" var="page">
            <c:if test="${ page == 0 || page == data.totalPages -1 || ( page >= data.number - 1 && page <= data.number + 1 && page < data.totalPages) }">

                <li class="page-item">
                    <a class="page-link"
                       href="/hoa-don/index?keyword=${keyword}&&page=${page}">
                            ${ page + 1}
                    </a>
                </li>
            </c:if>
            <c:if test="${ page > 1 && page < data.totalPages-1 && ( page == data.number - 2 || page == data.number + 2 ) }">

                <li class="page-item">
                    <a class="page-link "
                       href="">
                        ...
                    </a>
                </li>
            </c:if>
        </c:forEach>
        <li class="page-item" ><a class="page-link" href="/hoa-don/index?keyword=${keyword}&&page=${data.number + 1}">Next</a></li>
    </ul>
</nav>
</body>
</html>