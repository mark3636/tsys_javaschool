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

    <form action="/patient" method="post">
        <c:if test="${patient.id != 0}">
            <div>
                <input class="form-control" type="hidden" name="id" placeholder="name" value="${patient.id}"/>
            </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" id="name" name="name" placeholder="name" value="${patient.name}"/>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input class="form-control" type="text" id="surname" name="surname" placeholder="surname" value="${patient.surname}">
        </div>
        <div class="form-group">
            <label for="birthday">Birthday</label>
            <input class="form-control" type="date" id="birthday" name="birthday" value="${patient.birthday}">
        </div>
        <div class="form-group">
            <label for="passport">Passport details</label>
            <input class="form-control" type="text" id="passport" name="passportDetails" placeholder="passport details" value="${patient.passportDetails}">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input class="form-control" type="text" name="address" id="address" placeholder="address" value="${patient.address}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" type="email" name="email" id="email" placeholder="email" value="${patient.email}">
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone number</label>
            <input class="form-control" type="tel" name="phoneNumber" id="phoneNumber" placeholder="phone number" value="${patient.phoneNumber}">
        </div>
        <div class="form-group">
            <label for="ssn">Social security number</label>
            <input class="form-control" type="number" name="socialSecurityNumber" id="ssn" placeholder="social security number"
                   value="${patient.socialSecurityNumber}">
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
    </form>
</div>
</body>
</html>
