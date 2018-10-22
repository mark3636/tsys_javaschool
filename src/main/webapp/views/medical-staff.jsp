<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical staff</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h3>Medical staff list</h3>
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
