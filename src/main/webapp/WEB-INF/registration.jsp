<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/> ">
</head>
<body>
<div class="container">
    <div class="wrapper">
        <h4>Registration</h4>
        <form:form action="/registration" method="post" modelAttribute="medicalStaff" id="registration">
            <c:if test="${not empty error}">
                <p class="big-error">${error}</p>
            </c:if>
            <div class="form-group">
                <label for="email">Email</label>
                <input class="form-control" type="email" name="email" id="email" placeholder="Email"
                       value="${medicalStaff.email}"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="Password"
                       value="${medicalStaff.password}"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="password_confirmation">Password confirmation</label>
                <input class="form-control" type="password" name="password_confirmation" id="password_confirmation"
                       placeholder="Password confirmation"/>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" type="text" name="name" id="name" placeholder="Name"
                       value="${medicalStaff.name}"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="surname">Surname</label>
                <input class="form-control" type="text" id="surname" name="surname" placeholder="Surname"
                       value="${medicalStaff.surname}">
                <form:errors path="surname" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="birthday">Birthday</label>
                <spring:bind path="birthday">
                    <input id="birthday" class="form-control" type="text" placeholder="Birthday" value="${status.value}"
                           name="${status.expression}" readonly="readonly" style="background-color: white"/>
                    <c:if test="${status.error}">
                        <c:forEach items="${status.errorMessages}" var="error">
                            <span class="error"><c:out value="${error}"/></span>
                        </c:forEach>
                    </c:if>
                </spring:bind>
            </div>
            <div>
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Register"/>"/>
                <a href="/login">Back</a>
            </div>
        </form:form>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/registration.js"/> "></script>

</body>
</html>

