<!DOCTYPE html>
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@include file="head.jsp"%>
</head>
<body class="container">
<h3>${text}</h3>
<form action="/user/id" method="post" class="form-group">
    <input type="number" name="id_user_model" class="form-control">
    <button type="submit"  class="btn-info">Ok</button>
</form>

</body>

</html>