<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h3>Patient:</h3>
    <div>
        <a href="<c:url value="/patient-details/${patient.id}/new-visit"/> ">New visit</a> |
        <a href="<c:url value="/patient-details/${patient.id}/new-medical-case"/> ">Add medical case</a>
    </div>
    <div>Social security number: ${patient.socialSecurityNumber}</div>
    <div>Name: ${patient.name}</div>
    <div>Surname: ${patient.surname}</div>
    <div>Birthday: ${patient.birthday}</div>
    <div>Passport details: ${patient.passportDetails}</div>
    <div>Address: ${patient.address}</div>
    <div>Email: ${patient.email}</div>
    <div>Phone number: ${patient.phoneNumber}</div>
    <div>Patient status: ${patientStatus}</div>
    <c:if test="${not empty patient.comment}">
        <div>Comment: ${patient.comment}</div>
    </c:if>
    <c:if test="${empty medicalCases}">
        <div>No medical cases</div>
    </c:if>
    <c:if test="${not empty medicalCases}">
        <div>Medical cases:</div>
        <ul>
            <c:forEach items="${medicalCases}" var="medicalCase">
                <li>Case number: ${medicalCase.number} |
                    Beginning date: ${medicalCase.beginningDate} |
                    <c:if test="${not empty medicalCase.endingDate}">
                        Ending date: ${medicalCase.endingDate} |
                    </c:if>
                    Case status: ${medicalCase.caseStatus.name} |
                    <a href="<c:url value="/medical-case/${medicalCase.id}"/>">Details</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty medicalCases}">
        <div>No medical cases</div>
    </c:if>
    <c:if test="${not empty visits}">
        <div>Visits:</div>
        <ul>
            <c:forEach items="${visits}" var="visit">
                <li>Visit date: ${visit.visitDate} |
                    Beginning time: ${visit.beginningTime} |
                    Ending time: ${visit.endingTime} |
                    Medical staff: ${visit.medicalStaff.name} ${visit.medicalStaff.surname}
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <div>
        <a href="/patients">Back</a>
    </div>
</div>
</body>
</html>
