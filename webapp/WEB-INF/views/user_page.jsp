<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html leng="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
      integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<title>User Model</title>
<body>
<div class="container">
    <div class="container">
        <h3>user: ${user}</h3>
        <h3>user name ${user.name_user_model}</h3>
        <h3>${user}</h3>
    </div>

    <div class="container-fluid">
        <div class="alert alert-success" role="alert">
            <p>This them from user data </p>
        </div>

    </div>
</div>


</body>
</html>