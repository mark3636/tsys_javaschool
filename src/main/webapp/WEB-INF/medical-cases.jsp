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

    <h3>Medical cases</h3>
    <c:if test="${!empty medicalCases}">
        <table class="table table-striped">
            <tr>
                <th>Number</th>
                <th>Beginning date</th>
                <th>Ending date</th>
                <th>Case status</th>
                <th>Details</th>
                <th>Complete</th>
                <th>Cancel</th>
            </tr>
            <c:forEach items="${medicalCases}" var="medicalCase">
                <tr>
                    <td>${medicalCase.number}</td>
                    <td>${medicalCase.beginningDate}</td>
                    <td>
                        <c:if test="${not empty medicalCase.endingDate}">${medicalCase.endingDate}</c:if>
                        <c:if test="${empty medicalCase.endingDate}">Undefined</c:if>
                    </td>
                    <td>${medicalCase.caseStatus.name}</td>
                    <td><a href="<c:url value='/medical-case/${medicalCase.id}' />">Details</a></td>
                    <c:if test="${medicalCase.caseStatus.name eq 'OPENED'}">
                        <td><a href="<c:url value='/medical-case/${medicalCase.id}/complete' />">Complete</a></td>
                        <td><a href="<c:url value='/medical-case/${medicalCase.id}/cancel' />">Cancel</a></td>
                    </c:if>
                    <c:if test="${not(medicalCase.caseStatus.name eq 'OPENED')}">
                        <td>-</td>
                        <td>-</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
