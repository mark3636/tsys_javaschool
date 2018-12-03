<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <div>
        <h4>Patient: ${patient.name} ${patient.surname}</h4>
        <div>Social security number: ${patient.socialSecurityNumber}</div>
        <div>Birthday: <fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${patient.birthday}"/></div>
        <div>Email: ${patient.email}</div>
        <div>Phone number: ${patient.phoneNumber}</div>
        <div>Address: ${patient.address}</div>
        <div>Passport details: ${patient.passportDetails}</div>
        <div>Patient status: ${patientStatus}</div>
        <c:if test="${not empty patient.comment}">
            <div>Comment: ${patient.comment}</div>
        </c:if>
    </div>

    <div class="separator">
        <a href="<c:url value="/patient-details/${patient.id}/new-medical-case"/> " class="btn btn-secondary">New
            medical case</a>
        <c:if test="${empty medicalCases}">
            <div>Medical cases: none</div>
        </c:if>
        <c:if test="${not empty medicalCases}">
            <div>Medical cases:</div>
            <ul>
                <c:forEach items="${medicalCases}" var="medicalCase">
                    <li>Case number: ${medicalCase.number} |
                        Beginning date: <fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                                        value="${medicalCase.beginningDate}"/> |
                        <c:if test="${not empty medicalCase.endingDate}">
                            Ending date: <fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                                         value="${medicalCase.endingDate}"/> |
                        </c:if>
                        Case status: ${medicalCase.caseStatus.name} |
                        <a href="<c:url value="/medical-case/${medicalCase.id}"/>">Details</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>

    <div class="separator">
        <a href="<c:url value="/patient-details/${patient.id}/new-visit"/> " class="btn btn-secondary mr-2">New
            visit</a>
        <c:if test="${empty visits}">
            <div>Visits: none</div>
        </c:if>
        <c:if test="${not empty visits}">
            <div>Visits:</div>
            <ul>
                <c:forEach items="${visits}" var="visit">
                    <li>Visit date: <fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${visit.visitDate}"/> |
                        Beginning time: <fmt:formatDate type="time" timeStyle="short" value="${visit.beginningTime}"/> |
                        Ending time: <fmt:formatDate type="time" timeStyle="short" value="${visit.endingTime}"/> |
                        Medical
                        staff: ${visit.medicalStaff.role.alias} ${visit.medicalStaff.name} ${visit.medicalStaff.surname}
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>

    <div class="separator">
        <a href="/patients">Back</a>
    </div>
</div>
</body>
</html>
