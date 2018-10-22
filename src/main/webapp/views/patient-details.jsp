<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h3>Patient:</h3>
    <div>
        <a href="<c:url value="/patient-details/${patient.id}/new-visit"/> ">New visit</a>
        <a href="<c:url value="/patient-details/${patient.id}/add-case"/> ">Add medical case</a>
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
        <c:forEach items="${medicalCases}" var="medicalCase">
            <div>
                <div>Case number: ${medicalCase.number}</div>
                <div>Beginning date: ${medicalCase.beginningDate}</div>
                <c:if test="${not empty medicalCase.endingDate}">
                    <div>Ending date: ${medicalCase.endingDate}</div>
                </c:if>
                <div>Case status: ${medicalCase.caseStatus.name}</div>
                <div><a href="<c:url value="/medical-case/${medicalCase.id}"/>">Details</a></div>
            </div>
        </c:forEach>
    </c:if>
    <div>
        <a href="/patients">Back</a>
    </div>
</div>
</body>
</html>
