<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical cases</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <nav class="navbar navbar-light bg-light mb-2">
        <form class="form-inline" method="get" action="/medical-cases" id="search" style="margin-bottom: 0">
            <input class="form-control mr-sm-2" type="search" name="caseNumber" value="${caseNumber}"
                   placeholder="Medical case number"
                   aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="patientName" value="${patientName}"
                   placeholder="Patient name" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <c:if test="${!empty medicalCases}">
        <table class="table table-striped">
            <tr>
                <th>Number</th>
                <th>Patient</th>
                <th>Beginning date</th>
                <th>Ending date</th>
                <th>Case status</th>
                <th>Details</th>
                <th>Complete</th>
                <th>Cancel</th>
            </tr>
            <c:forEach items="${medicalCases}" var="medicalCase">
                <tr id="tr-${medicalCase.id}">
                    <td>${medicalCase.number}</td>
                    <td>${medicalCase.patient.name} ${medicalCase.patient.surname}</td>
                    <td>${medicalCase.beginningDate}</td>
                    <td>
                        <c:if test="${not empty medicalCase.endingDate}">${medicalCase.endingDate}</c:if>
                        <c:if test="${empty medicalCase.endingDate}">Undefined</c:if>
                    </td>
                    <td>${medicalCase.caseStatus.name}</td>
                    <td><a href="<c:url value='/medical-case/${medicalCase.id}' />">Details</a></td>
                    <c:if test="${medicalCase.caseStatus.name eq 'OPENED'}">
                        <td><a href="#" onclick="changeMedicalCaseStatus(${medicalCase.id}, 'COMPLETED')">Complete</a>
                        </td>
                        <td><a href="#" onclick="changeMedicalCaseStatus(${medicalCase.id}, 'CANCELLED')">Cancel</a>
                        </td>
                    </c:if>
                    <c:if test="${medicalCase.caseStatus.name eq 'COMPLETED'}">
                        <td>+</td>
                        <td>-</td>
                    </c:if>
                    <c:if test="${medicalCase.caseStatus.name eq 'CANCELLED'}">
                        <td>-</td>
                        <td>+</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/medical-cases.js"/> "></script>

</body>
</html>
