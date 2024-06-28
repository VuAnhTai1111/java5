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
<form action="/kich-thuoc/index" method="get">
    <input type="text" name="keyword" value="${keyword}" placeholder="Mã hoặc Tên">
    <button>Tim</button>
</form>
<hr>
<form action="/kich-thuoc/create" method="get">
    <button>Create</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="kt">
        <tr>
            <td>${kt.id}</td>
            <td>${kt.ma}</td>
            <td>${kt.ten}</td>
            <td>${kt.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td><a href="/kich-thuoc/edit/${kt.id}">Update</a></td>
            <td><a href="/kich-thuoc/delete/${kt.id}">Delete</a></td>
        </tr>
    </c:forEach>
<%--    <tr>--%>
<%--        <td>1</td>--%>
<%--        <td>A001</td>--%>
<%--        <td>Áo khoác da</td>--%>
<%--        <td>Ngưng hoạt động</td>--%>
<%--        <td><a href="">Update</a></td>--%>
<%--        <td><a href="">Delete</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>2</td>--%>
<%--        <td>A002</td>--%>
<%--        <td>Áo sơ mi</td>--%>
<%--        <td>Đang hoạt động</td>--%>
<%--        <td><a href="">Update</a></td>--%>
<%--        <td><a href="">Delete</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>3</td>--%>
<%--        <td>A003</td>--%>
<%--        <td>Áo phông</td>--%>
<%--        <td>Đang hoạt động</td>--%>
<%--        <td><a href="">Update</a></td>--%>
<%--        <td><a href="">Delete</a></td>--%>
<%--    </tr>--%>
    </tbody>

</table>
<nav aria-label="Page navigation example" style="margin-left: 30%">
    <ul class="pagination">
        <li class="page-item" aria-disabled="true">
                <a class="page-link" href="/kich-thuoc/index?keyword=${keyword}&&page=${data.number - 1}">Previous</a>
        </li>
        <c:forEach begin="0" end="${ data.totalPages }" var="page">
            <c:if test="${ page == 0 || page == data.totalPages -1 || ( page >= data.number - 1 && page <= data.number + 1 && page < data.totalPages) }">

                <li class="page-item">
                    <a class="page-link"
                       href="/kich-thuoc/index?keyword=${keyword}&&page=${page}">
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
        <li class="page-item" ><a class="page-link" href="/kich-thuoc/index?keyword=${keyword}&&page=${data.number + 1}">Next</a></li>
    </ul>
</nav>
</body>
</html>