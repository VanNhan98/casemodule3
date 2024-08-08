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
        <div class="table-title ">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Product</b></h2>
                </div>
                <div class="col-sm-6">
                    <button style="padding: 10px 20px" type="submit" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#addEmployeeModal">Add
                    </button>
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
                        <div class="btn-action">
                            <a href="delete?id=${o.id}" class="btn btn-danger" style="margin-right: 10px;">Delete</a>
                            <a href="loadProduct?id=${o.id}" class="btn btn-warning">Edit</a>
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

<%--add modal--%>
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addProduct" method="post">
                <div class="modal-header d-flex justify-content-between ">
                    <h4 class="modal-title">Add Product</h4>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-hidden="true">X</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <textarea name="title" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listC}" var="o">
                                <option value="${o.id}">${o.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-between">
                    <input id="addButton" type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<%--end add modal--%>
</body>


</html>
