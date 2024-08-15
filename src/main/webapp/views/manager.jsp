<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .btn-action {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        .pagination > li > a {
            color: #495057;
            float: left;
            padding: 6px 12px;
            text-decoration: none;
            transition: background-color 0.3s;
        }


    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header text-white" style="background: #435d7d">
                    <div class="row">
                        <div class="col-12">
                            <h2>Manage <b>Product</b></h2>
                        </div>
                        <div class="col-12 text-end">
                            <button style="padding: 10px 20px" type="submit" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#addEmployeeModal">Add
                            </button>
                        </div>
                    </div>
                </div>
                <div class="table">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" id="selectAll">
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listProducts}" var="o">
                            <tr>
                                <td>
                                    <input type="checkbox" id="checkbox1" name="options" value="1">
                                </td>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img class="img-fluid" style="width: 120px; height: 100px; object-fit: cover" src="/image/${o.image}" alt="">
                                </td>
                                <td>${o.price} $</td>
                                <td>
                                    <div class="btn-action d-flex justify-content-center">
                                        <a href="delete?id=${o.id}" class="btn btn-danger" style="margin-right: 5px;">Delete</a>
                                        <a href="loadProduct?id=${o.id}" class="btn btn-warning">Edit</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer d-flex justify-content-between align-items-center">
                    <ul class="pagination m-0">
                        <c:if test="${tag > 1}">
                            <li class="page-item"><a href="managerproducts?index=${tag -1}" class="page-link">Previous</a></li>
                        </c:if>

                        <c:forEach begin="1" end="${endPage}" var="i">
                            <li class="page-item ${tag == i ? "active" :""}"><a href="managerproducts?index=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                        <c:if test="${tag < endPage}">
                            <li class="page-item"><a href="managerproducts?index=${tag + 1}" class="page-link">Next</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <a href="home" class="btn btn-secondary mt-3">Back to home</a>
        </div>

    </div>

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
