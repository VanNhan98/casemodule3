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
    <style>
        nav {
            background: #435d7d;
            width: 100%;
            padding: 20px 10%;
            display: flex;
            align-items: center;
            justify-content: space-between;
            position: relative;
        }

        .user-pic {
            width: 40px;
            border-radius: 50%;
            cursor: pointer;
            margin-left: 30px;
        }

        nav ul {
            width: 100%;
            text-align: right;
        }

        nav ul li {
            display: inline-block;
            margin-left: 10px
        }

        nav ul li a {
            color: #ffffff;
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="hero">
    <nav>
        <form action="search" method="post" class="form-inline my-2 my-lg-0">
            <div class="input-group input-group-sm">
                <input oninput="searchByName(this)" value="${nameDefault}" name="searchName" type="text" class="form-control"
                       placeholder="Search...">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary btn-number">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <ul>
            <li><a href="home">Home</a></li>
            <c:if test="${sessionScope.account.isadmin == 1}">
                <li><a href="#">Manager</a></li>
            </c:if>
            <c:if test="${sessionScope.account.sell == 1}">
                <li><a href="managerproducts">Manager</a></li>
            </c:if>

            <c:if test="${sessionScope.account == null}">
                <li><a href="login">Login</a></li>
            </c:if>

            <c:if test="${sessionScope.account != null}">
                <li><a href="logout">Logout</a></li>
                <li><a href="#">${sessionScope.account.username}</a></li>
            </c:if>

        </ul>
        <img src="/image/avatar/123.png" class="user-pic">
    </nav>
</div>

</body>

</html>
