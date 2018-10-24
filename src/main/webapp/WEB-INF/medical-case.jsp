<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical case</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <div>Number: ${medicalCase.number}</div>
    <div>Beginning date: ${medicalCase.beginningDate}</div>
    <div>Ending date:
        <c:if test="${not empty medicalCase.endingDate}">${medicalCase.endingDate}</c:if>
        <c:if test="${empty medicalCase.endingDate}">Undefined</c:if>
    </div>
    <div>Case status: ${medicalCase.caseStatus.name}</div>
    <div>Patient's ssn: ${medicalCase.patient.socialSecurityNumber}</div>
    <div>Medical staff: ${medicalCase.medicalStaff.name}</div>

    <a href="/medical-case/${medicalCase.id}/diagnosis" class="btn btn-primary mb-2">New diagnosis</a>

    <c:if test="${not empty diagnoses}">
        <div>Diagnoses:</div>
            <ul>
            <c:forEach items="${diagnoses}" var="diagnosis">
                <li>
                    Name :${diagnosis.name}, date: ${diagnosis.diagnosisDate} |  <a href="/medical-case/${medicalCase.id}/diagnosis-details/${diagnosis.id}">Details</a> | <a href="/medical-case/${medicalCase.id}/diagnosis/${diagnosis.id}">Edit</a>
                </li>
            </c:forEach>
            </ul>
    </c:if>

    <div><c:if test="${empty diagnoses}">No diagnoses</c:if></div>

    <form method="post" action="/medical-case/${medicalCase.id}/upload" enctype="multipart/form-data">
        <div class="form-group">
            <input class="form-control-file" type="file" name="file" id="file"/>
            <input class="mt-2 btn btn-primary" type="submit" value="Add document"/>
        </div>
    </form>

    <c:if test="${not empty pdfFiles}">
        <div>Attachments:</div>
            <ul>
            <c:forEach items="${pdfFiles}" var="pdfFile">
                <li>
                    ${pdfFile.name} | <a href="/medical-case/${medicalCase.id}/pdf-file/${pdfFile.id}/download">Download</a> |
                    <a href="/medical-case/${medicalCase.id}/pdf-file/${pdfFile.id}/delete">Delete</a>
                </li>
            </c:forEach>
            </ul>
    </c:if>

    <c:if test="${empty pdfFiles}">No attachments</c:if>
</div>
</body>
</html>
