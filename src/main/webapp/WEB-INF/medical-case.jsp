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

    <h4>Medical case</h4>
    <div>Number: ${medicalCase.number}</div>
    <div>Beginning date: ${medicalCase.beginningDate}</div>
    <div>Ending date:
        <c:if test="${not empty medicalCase.endingDate}">${medicalCase.endingDate}</c:if>
        <c:if test="${empty medicalCase.endingDate}">In progress</c:if>
    </div>
    <div>Case status: ${medicalCase.caseStatus.name}</div>
    <div>Patient's ssn: ${medicalCase.patient.socialSecurityNumber}</div>
    <div>Medical staff: Dr. ${medicalCase.medicalStaff.name} ${medicalCase.medicalStaff.surname}</div>

    <div>
        <c:if test="${not empty medicalProcedures}">
            <div>Medical procedures:</div>
            <ul>
                <c:forEach items="${medicalProcedures}" var="medicalProcedure">
                    <li>
                        Name: ${medicalProcedure.name} | <a
                            href="/procedure-details/${medicalProcedure.id}">Details</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <div><c:if test="${empty medicalProcedures}">Medical procedures: no</c:if></div>

        <c:if test="${medicalCase.caseStatus.name eq 'OPENED'}">
            <a href="/medical-case/${medicalCase.id}/medical-procedure" class="btn btn-primary mb-2">New medical
                procedure</a>
        </c:if>
    </div>

    <div>
        <c:if test="${not empty diagnoses}">
            <div>Diagnoses:</div>
            <ul>
                <c:forEach items="${diagnoses}" var="diagnosis">
                    <li>
                        Name: ${diagnosis.name}, date: ${diagnosis.diagnosisDate} | <a
                            href="/medical-case/${medicalCase.id}/diagnosis-details/${diagnosis.id}">Details</a> | <a
                            href="/medical-case/${medicalCase.id}/diagnosis/${diagnosis.id}">Edit</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <div><c:if test="${empty diagnoses}">Diagnoses: no</c:if></div>

        <c:if test="${medicalCase.caseStatus.name eq 'OPENED'}">
            <a href="/medical-case/${medicalCase.id}/diagnosis" class="btn btn-primary mb-2">New diagnosis</a>
        </c:if>
    </div>

    <div>
        <c:if test="${empty pdfFiles}">Attachments: no</c:if>

        <c:if test="${not empty pdfFiles}">
            <div>Attachments:</div>
            <ul>
                <c:forEach items="${pdfFiles}" var="pdfFile">
                    <li>
                            ${pdfFile.name}
                        | <a href="/medical-case/${medicalCase.id}/pdf-file/${pdfFile.id}/download">Download</a>
                        | <a href="/medical-case/${medicalCase.id}/pdf-file/${pdfFile.id}/delete">Delete</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${medicalCase.caseStatus.name eq 'OPENED'}">
            <form method="post" action="/medical-case/${medicalCase.id}/upload" enctype="multipart/form-data">
                <div class="form-group">
                    <input class="form-control-file" type="file" name="file" id="file"/>
                    <input class="mt-2 btn btn-primary" type="submit" value="Add attachment"/>
                </div>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
