<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-md">
    <div class="container">
        <div class="row">
            <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                <ul class="navbar-nav m-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manager Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello Alias</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                </ul>
                <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${nameDefault}" name="searchName" type="text" class="form-control"
                                   placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>

                        <a class="btn btn-danger btn-sm ml-3 mt-3" href="show">
                            <i class="fa fa-shopping-cart"></i>
                            <span class="badge badge-light" style="font-weight: bold">3</span>
                        </a>


                </form>
            </div>

        </div>
    </div>

</nav>
</body>
</html>
