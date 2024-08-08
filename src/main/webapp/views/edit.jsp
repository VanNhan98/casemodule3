<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="/css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        .modal {
            display: block;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            position: absolute; /* Canh chỉnh tuyệt đối */
            top:30px; /* Dính với mép trên web */
            left: 50%;
            transform: translateX(-50%); /* Canh giữa theo chiều ngang */
            background-color: #fefefe;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            text-decoration: none;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
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
            </div>
        </div>
    </div>
    <div class="modal" id="myModal" >
        <div class="modal-content" >
            <form action="editProduct" method="post">
                <div class="modal-header d-flex justify-content-between">
                    <h4 class="modal-title">Modal Title</h4>
                    <a href="managerproducts" class="close">x</a>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input value="${detail.name}" name="name" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input value="${detail.image}" name="image" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input value="${detail.price}" name="price" type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <textarea name="title" class="form-control">${detail.title}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control">${detail.description}</textarea>
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
                    <a id="cancelButton" class="btn btn-default" href="managerproducts">Cancel</a>
                    <input type="submit" class="btn btn-success" value="Save">
                </div>
            </form>
        </div>
    </div>

</div>

</body>

</html>
