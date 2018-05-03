<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <title>Login</title>
</head>
<body class="container">
<div c:if="${param["Retry"]}">Invalid username and password.</div>

<form action="/login" method="post">
    <div class="form-group" ><label for="userName">User Name : <input type="text" id="userName" name="username" class="form-control" value="" placeholder="Enter user name"/></label></div>
    <div class="form-group"><label  for="userPassword">Password : <input type="password" id="userPassword" name="password" class="form-control" placeholder="Enter password"/></label></div>
    <div><button  class="btn btn-primary" type="submit">Sign In</button></div>
</form>
</body>
</html>