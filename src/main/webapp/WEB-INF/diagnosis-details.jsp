<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Diagnosis details</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <h3>Diagnosis:</h3>
    <div>Name: ${diagnosis.name}</div>
    <div>Diagnosis date: ${diagnosis.diagnosisDate}</div>
    <div>Medical staff: ${diagnosis.medicalStaff.name} ${diagnosis.medicalStaff.surname}</div>
    <c:if test="${not empty diagnosis.comment}">
        <div>Comment: ${diagnosis.comment}</div>
    </c:if>
    <div>
        <a href="/medical-case/${diagnosis.medicalCase.id}">Back</a>
    </div>
</div>
</body>
</html>
