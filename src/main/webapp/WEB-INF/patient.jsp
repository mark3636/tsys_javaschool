<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form:form action="/patient" method="post" modelAttribute="patient">
        <c:if test="${patient.id != 0}">
            <div>
                <input class="form-control" type="hidden" name="id" placeholder="name" value="${patient.id}"/>
            </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" name="name" id="name" placeholder="name" value="${patient.name}"/>
            <form:errors path="name" cssClass="help-block"/>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input class="form-control" type="text" id="surname" name="surname" placeholder="surname" value="${patient.surname}">
            <form:errors path="surname"/>
        </div>
        <div class="form-group">
            <label for="birthday">Birthday</label>
            <spring:bind path="birthday">
                <input id="birthday" class="form-control" type="date" value="${status.value}" name="${status.expression}">
                <c:if test="${status.error}">
                    <c:forEach items="${status.errorMessages}" var="error">
                        <c:out value="${error}"/>
                    </c:forEach>
                </c:if>
            </spring:bind>
        </div>
        <div class="form-group">
            <label for="passport">Passport details</label>
            <input class="form-control" type="text" id="passport" name="passportDetails" placeholder="passport details" value="${patient.passportDetails}">
            <form:errors path="passportDetails"/>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input class="form-control" type="text" name="address" id="address" placeholder="address" value="${patient.address}">
            <form:errors path="address"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" type="email" name="email" id="email" placeholder="email" value="${patient.email}">
            <form:errors path="email"/>
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone number (5 - 11 numbers)</label>
            <input class="form-control" type="tel" name="phoneNumber" id="phoneNumber" placeholder="phone number" value="${patient.phoneNumber}">
            <form:errors path="phoneNumber"/>
        </div>
        <div class="form-group">
            <label for="ssn">Social security number (9 numbers)</label>
            <input class="form-control" type="text" name="socialSecurityNumber" id="ssn" placeholder="social security number"
                   value="${patient.socialSecurityNumber}">
            <form:errors path="socialSecurityNumber"/>
        </div>
        <div class="form-group">
            <label for="comment">Comment</label>
            <textarea class="form-control" name="comment" id="comment" placeholder="comment">${patient.comment}</textarea>
        </div>
        <div>
            <c:if test="${patient.id != 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Edit"/>"/>
            </c:if>
            <c:if test="${patient.id == 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Add"/>"/>
            </c:if>
            <a href="/patients">Back</a>
        </div>
    </form:form>
</div>
</body>
</html>
