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
<form action="/spct/index" method="get">
    Sản phẩm:
    <select name="spId" id="">
<%--        <option value="Ao Phong">Ao Phong </option>--%>
<%--        <option value="Ao So Mi">Ao So Mi </option>--%>
        <c:forEach items="${datasp}" var="sp">
            <option value="${sp.id}" ${spId==sp.id? "selected":""}>${sp.ten}</option>
        </c:forEach>
    </select>
    <button>Tìm</button>
</form>

<%--<form action="/spct/searchMau" method="get">--%>
<%--    Màu sắc:--%>
<%--    <select name="mauSac">--%>
<%--        <c:forEach items="${datams}" var="ms">--%>
<%--            <option value="${ms.id}">${ms.ten}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <button>Tìm</button>--%>
<%--</form>--%>

<%--<form action="/spct/searchGia" method="get">--%>
<%--    <p>Đơn giá</p>--%>
<%--    Từ:--%>
<%--    <input type="text" name="tu">--%>
<%--    Đến:--%>
<%--    <input type="text" name="den">--%>
<%--    <button>Tìm</button>--%>
<%--</form>--%>
<hr>
<form action="/spct/create" method="get">
    <button>Create</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Mã</th>
        <th>Tên sản phẩm</th>
        <th> Màu sắc</th>
        <th> kích thước</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="ct">
        <tr>
        <td>${ct.id}</td>
        <td>${ct.ma}</td>
        <td>${ct.tenSP}</td>
        <td>${ct.mauSac}</td>
        <td>${ct.kichThuoc}</td>
        <td>${ct.soLuong}</td>
        <td>${ct.donGia}</td>
        <td>${ct.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
        <td><a href="/spct/edit/${ct.id}">Update</a></td>
        <td><a href="/spct/delete/${ct.id}">Delete</a></td>
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
<nav aria-label="Page navigation example" style="margin-left: 30%">
    <ul class="pagination">
        <li class="page-item" aria-disabled="true">
            <a class="page-link" href="/spct/index?spId=${spId}&&page=${data.number - 1}">Previous</a>

        </li>
        <c:forEach begin="0" end="${ data.totalPages }" var="page">
            <c:if test="${ page == 0 || page == data.totalPages -1 || ( page >= data.number - 1 && page <= data.number + 1 && page < data.totalPages) }">

                <li class="page-item">
                    <a class="page-link"
                       href="/spct/index?spId=${spId}&&page=${page}">
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
        <li class="page-item" ><a class="page-link" href="/spct/index?spId=${spId}&&page=${data.number + 1}">Next</a></li>
    </ul>
</nav>
</body>
</html>