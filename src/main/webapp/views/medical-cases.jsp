<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical cases</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
                <th>Change status</th>
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
                    <td><a href="<c:url value='/medical-case/${medicalCase.id}/change-status' />">Change status</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
