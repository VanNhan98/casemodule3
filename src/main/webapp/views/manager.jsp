
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="/css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        .btn-action {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Product</b></h2>
                </div>
                <div class="col-sm-6">
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                    </span>
                </th>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lists}" var="o">
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options" value="1">
                            <label for="checkbox1"></label>
                        </span>
                    </td>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td>
                        <img style="width: 120px; height: 100px; object-fit: cover" src="/image/${o.image}" alt="">
                    </td>
                    <td>${o.price} $</td>
                    <td>
                        <div class="btn-action" >
                            <button type="submit" class="btn btn-danger">Delete</button>
                            <button type="submit" class="btn btn-primary">Add</button>
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </div>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix">
            <%--            <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>--%>
            <ul class="pagination">
                <li class="page-item disabled"><a href="#">Previous</a></li>
                <li class="page-item"><a href="#" class="page-link">1</a></li>
                <li class="page-item"><a href="#" class="page-link">2</a></li>
                <li class="page-item active"><a href="#" class="page-link">3</a></li>
                <li class="page-item"><a href="#" class="page-link">4</a></li>
                <li class="page-item"><a href="#" class="page-link">5</a></li>
                <li class="page-item"><a href="#" class="page-link">Next</a></li>
            </ul>
        </div>
    </div>
    <a href="home">
        <button type="button" class="btn btn-primary">Back to home</button>
    </a>
</div>
</body>
<script src="js/manager.js" type="text/javascript"></script>
</html>
