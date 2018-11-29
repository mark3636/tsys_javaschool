<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<security:authorize access="hasRole('DOCTOR')" var="isDoctor"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Medical procedure details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <h4>Medical procedure:</h4>
    <div>Name: ${medicalProcedure.name}</div>
    <div>Description: ${medicalProcedure.description}</div>
    <div>Status: ${medicalProcedure.procedureStatus.name}</div>

    <div>Procedure date:
        <c:if test="${not empty medicalProcedure.medicalStaff}">
            <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${medicalProcedure.procedureDate}"/>
        </c:if>
        <c:if test="${empty medicalProcedure.medicalStaff}">
            <c:out value="-"/>
        </c:if>
    </div>
    <div>Medical staff:
        <c:if test="${not empty medicalProcedure.medicalStaff}">
            <c:out value="${medicalProcedure.medicalStaff.role.alias} ${medicalProcedure.medicalStaff.name} ${medicalProcedure.medicalStaff.surname}"/>
        </c:if>
        <c:if test="${empty medicalProcedure.medicalStaff}">
            <c:out value="-"/>
        </c:if>
    </div>
    <c:if test="${not empty medicalProcedure.medicalStaff}">
        <div>Comment: ${medicalProcedure.comment}</div>
    </c:if>
    <c:if test="${isDoctor}">
        <div>
            <a href="/medical-case/${medicalProcedure.medicalCase.id}">To medical case</a> |
            <a href="/medical-procedures">To medical procedures</a>
        </div>
    </c:if>
    <c:if test="${not isDoctor}">
        <div>
            <a href="/medical-procedures">Back</a>
        </div>
    </c:if>
</div>
</body>
</html>
