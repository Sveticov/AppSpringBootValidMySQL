<!DOCTYPE>
<html>
<head>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="head.jsp"%>
    <title>Join</title>
</head>
<body>
<div class="container">
    <h3>${title}</h3>
    <form action="/us/cart/model" method="post" class="form-group">
        <input type="number" name="id_us_cart" class="form-control">
        <button type="submit" class="btn-info">Find id</button>
    </form>
</div>
</body>
</html>