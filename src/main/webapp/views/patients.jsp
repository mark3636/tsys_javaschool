<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Patients</title>
</head>
<body>
<a href="<c:url value='/patient'/>">Add Patient</a>
<h3>Patients list</h3>
<c:if test="${!empty listPatients}">
    <table class="tg">
        <tr>
            <th width="120">Name</th>
            <th width="120">Surname</th>
            <th width="120">Social security number</th>
            <th width="60">Details</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPatients}" var="patient">
            <tr>
                <td>${patient.name}</td>
                <td>${patient.surname}</td>
                <td>${patient.socialSecurityNumber}</td>
                <td><a href="<c:url value='/patient-details/${patient.id}' />" >Details</a></td>
                <td><a href="<c:url value='/patient/${patient.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${patient.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
