<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>

        .container {
            max-width: 360px;
            margin:  auto;
            padding-top: 100px;
        }

        form {
            background-color: #f1f1f1;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            border: 2px solid #ffffff;
        }

        .form-floating > .form-control {
            border-radius: 0 ;
        }

        .txt {
            display: block;
            text-align: center;
            font-size: 1.5em;
            margin-bottom: 20px;
        }
    </style>

</head>
<body>
<div class="container">

    <div class="row signup-form" id="signupForm">
        <form action="signup" method="post">
            <label  class="txt">Sign Up</label>
            <p class="text-danger">${errormatch}</p>
            <div class="form-floating">
                <input name="username" type="text" class="form-control" placeholder="name@example.com">
                <label>Email address</label>
            </div>
            <div class="form-floating mb-3">
                <input name="password" type="password" class="form-control" placeholder="Password">
                <label>Password</label>
            </div>
            <div class="form-floating mb-3">
                <input name="repass" type="password" class="form-control" placeholder="Password">
                <label>Repeat Password</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
            <a href="login" id="cancelSignup"> Back</a>
        </form>
    </div>
</div>

</body>

</html>
