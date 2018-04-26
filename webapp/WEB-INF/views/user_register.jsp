<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<title>User register</title>

<body>
<%@ include file="head.jsp" %>

<div class="container">
    <h3>User registration ${title}</h3>
    <div>
        <div class="form-group">


            <form:form method="post" modelAttribute="user1" action="/user/add">
                <div>
                    <div>
                        <ul>
                            <li><form:input type="number" path="id_user_model"/></li>
                            <li><spring:bind path="name_user_model">
                                <form:input path="name_user_model"/>
                                <form:errors path="name_user_model"/>
                            </spring:bind></li>

                        </ul>


                            <%--<form:input path="date_user_model"/>--%>
                        <input type="submit" value="Submit"/>
                    </div>
                </div>

            </form:form>

        </div>

    </div>
</div>


</body>
</html>