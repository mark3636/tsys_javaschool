<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical staff</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h4>Medical staff</h4>
    <c:if test="${!empty listMedicalStaff}">
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Birthday</th>
            </tr>
            <c:forEach items="${listMedicalStaff}" var="medicalStaff">
                <tr>
                    <td>${medicalStaff.name}</td>
                    <td>${medicalStaff.surname}</td>
                    <td>${medicalStaff.email}</td>
                    <td>${medicalStaff.birthday}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
