<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"/>
</head>
<body>
<!-- Include menu -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- Main container -->
<div class="container" style="min-height: 600px;">
    <div class="row mt-5">
        <div class="container">
            <div class="row" >
                <!-- Include left sidebar -->
                <jsp:include page="left.jsp"></jsp:include>

                <!-- Product list -->
                <div class="col-sm-9">
                    <div class="row" id="content">
                        <c:forEach items="${listProducts}" var="o">
                            <div class=" amount col-12 col-md-6 col-lg-4 mb-3">
                                <div class="card h-100">
                                    <img class="card-img-top" src="/image/${o.image}" alt="${o.name}">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt">
                                            <a style="text-decoration: none; color: black; display: flex; justify-content: center; white-space: nowrap;" href="detail?id=${o.id}" title="View Product">${o.name}</a>
                                        </h4>
                                        <div class="row">
                                            <div class="col d-flex justify-content-center">
                                                <p class="btn btn-success">${o.price} $</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <button onclick="loadMore()" class="btn btn-primary">Load More</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function loadMore() {
        let amount = document.getElementsByClassName("amount").length;
        $.ajax({
            url: "/load",
            type: "get",
            data: {
                exists: amount
            },
            success: function(data) {
                let row = document.getElementById("content");
                row.innerHTML += data;
                sessionStorage.setItem('loadedContent', row.innerHTML);
            },
            error: function(xhr) {

            }
        });
    }

    function searchByName(params) {
        let nameSearch = params.value;
        $.ajax({
            url: "/searchAjax",
            type: "get",
            data: {
                name: nameSearch
            },
            success: function(data) {
                let row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function(xhr) {

            }
        });
    }

    $(document).ready(function () {
        let loadedContent = sessionStorage.getItem('loadedContent');
        if (loadedContent) {
            document.getElementById('content').innerHTML = loadedContent;
        }
    });
</script>
</body>
</html>
