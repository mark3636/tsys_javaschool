<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form:form action="/patient" method="post" modelAttribute="patient" id="patient">
        <c:if test="${patient.id != 0}">
            <div>
                <input class="form-control" type="hidden" name="id" value="${patient.id}"/>
            </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" name="name" id="name" placeholder="Name" value="${patient.name}"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input class="form-control" type="text" id="surname" name="surname" placeholder="Surname"
                   value="${patient.surname}">
            <form:errors path="surname" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="birthday">Birthday</label>
            <spring:bind path="birthday">
                <input id="birthday" class="form-control" type="text" placeholder="Birthday" readonly
                       style="background-color: white" value="${status.value}"
                       name="${status.expression}">
                <c:if test="${status.error}">
                    <c:forEach items="${status.errorMessages}" var="error">
                        <span class="error"><c:out value="${error}"/></span>
                    </c:forEach>
                </c:if>
            </spring:bind>
        </div>
        <div class="form-group">
            <label for="passportDetails">Passport details</label>
            <input class="form-control" type="text" id="passportDetails" name="passportDetails" placeholder="Passport details"
                   value="${patient.passportDetails}">
            <form:errors path="passportDetails" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input class="form-control" type="text" name="address" id="address" placeholder="Address"
                   value="${patient.address}">
            <form:errors path="address" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" type="email" name="email" id="email" placeholder="Email"
                   value="${patient.email}">
            <form:errors path="email" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone number (5 - 11 numbers)</label>
            <input class="form-control" type="tel" name="phoneNumber" id="phoneNumber" placeholder="Phone number"
                   value="${patient.phoneNumber}">
            <form:errors path="phoneNumber" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="socialSecurityNumber">Social security number (9 numbers)</label>
            <input class="form-control" type="number" name="socialSecurityNumber" id="socialSecurityNumber"
                   placeholder="Social security number"
                   value="${patient.socialSecurityNumber}">
            <form:errors path="socialSecurityNumber" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="comment">Comment</label>
            <textarea class="form-control" name="comment" id="comment"
                      placeholder="Comment">${patient.comment}</textarea>
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

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/patient.js"/> "></script>

</body>
</html>
