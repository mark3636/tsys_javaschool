<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Diagnosis details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h4>Diagnosis: ${diagnosis.name}</h4>
    <div>Diagnosis date: <fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                         value="${diagnosis.diagnosisDate}"/></div>
    <div>Medical case: ${diagnosis.medicalCase.number}</div>
    <div>Patient: ${diagnosis.medicalCase.patient.name} ${diagnosis.medicalCase.patient.surname}</div>
    <div>Patient SSN: ${diagnosis.medicalCase.patient.socialSecurityNumber}</div>
    <div>Medical
        staff: ${diagnosis.medicalStaff.role.alias} ${diagnosis.medicalStaff.name} ${diagnosis.medicalStaff.surname}</div>
    <c:if test="${not empty diagnosis.comment}">
        <div>Comment: ${diagnosis.comment}</div>
    </c:if>
    <div>
        <a href="/medical-case/${diagnosis.medicalCase.id}">Back</a>
    </div>
</div>
</body>
</html>
