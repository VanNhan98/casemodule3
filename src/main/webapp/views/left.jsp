<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
  <div class="card bg-light mb-3">
    <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
    <ul class="list-group category_block">
      <c:forEach items="${listC}" var="o">
        <li class="list-group-item text-white ${tag == o.id ? "active" : ""} " >
        <a href="category?id=${o.id}">${o.name}</a></li>
      </c:forEach>
    </ul>
  </div>
</div>
