<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--<%@ page session="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient</title>
</head>
<body>
    <form action="/patient" method="post">
        <c:if test="${not empty patient.name}">
            <div>
                <input type="hidden" name="id" placeholder="name" value="${patient.id}"/>
            </div>
        </c:if>
        <div>
            <input type="text" name="name" placeholder="name" value="${patient.name}"/>
        </div>
        <div>
            <input type="text" name="surname" placeholder="surname" value="${patient.surname}">
        </div>
        <div>
            <input type="date" name="birthday" value="${patient.birthday}">
        </div>
        <div>
            <input type="text" name="passportDetails" placeholder="passport details" value="${patient.passportDetails}">
        </div>
        <div>
            <input type="text" name="address" placeholder="address" value="${patient.address}">
        </div>
        <div>
            <input type="email" name="email" placeholder="email" value="${patient.email}">
        </div>
        <div>
            <input type="tel" name="phoneNumber" placeholder="phone number" value="${patient.phoneNumber}">
        </div>
        <div>
            <input type="number" name="socialSecurityNumber" placeholder="social security number" value="${patient.socialSecurityNumber}">
        </div>
        <div>
            <input type="text" name="comment" placeholder="comment" value="${patient.comment}">
        </div>
        <div>
            <c:if test="${not empty patient.name}">
                <input type="submit"
                       value="<spring:message text="Edit"/>" />
            </c:if>
            <c:if test="${empty patient.name}">
                <input type="submit"
                       value="<spring:message text="Add"/>" />
            </c:if>
            <a href="/patients">Back</a>
        </div>
    </form>
</body>
</html>
