<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Medical case</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <div>
        <h4>Medical case: ${medicalCase.number}</h4>
        <div>Beginning date: <fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                             value="${medicalCase.beginningDate}"/></div>
        <div>Ending date:
            <c:if test="${not empty medicalCase.endingDate}"><fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                                                             value="${medicalCase.endingDate}"/></c:if>
            <c:if test="${empty medicalCase.endingDate}">Undefined</c:if>
        </div>
        <div>Case status: ${medicalCase.caseStatus.name}</div>
        <div>Patient: ${medicalCase.patient.name} ${medicalCase.patient.surname}</div>
        <div>Patient SSN: ${medicalCase.patient.socialSecurityNumber}</div>
        <div>Medical
            staff: ${medicalCase.medicalStaff.role.alias} ${medicalCase.medicalStaff.name} ${medicalCase.medicalStaff.surname}
        </div>
    </div>

    <div class="separator">
        <c:if test="${not(medicalCase.caseStatus.name eq 'CANCELLED')}">
            <a href="/medical-case/${medicalCase.id}/medical-procedure" class="btn btn-secondary mb-2">New medical
                procedure</a>
        </c:if>

        <c:if test="${not empty medicalProcedures}">
            <div>Medical procedures:</div>
            <ul>
                <c:forEach items="${medicalProcedures}" var="medicalProcedure">
                    <li>
                        Name: ${medicalProcedure.name} | Status: ${medicalProcedure.procedureStatus.name} | <a
                            href="/procedure-details/${medicalProcedure.id}">Details</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <div><c:if test="${empty medicalProcedures}">Medical procedures: none</c:if></div>
    </div>

    <div class="separator">
        <c:if test="${not(medicalCase.caseStatus.name eq 'CANCELLED')}">
            <a href="/medical-case/${medicalCase.id}/diagnosis" class="btn btn-secondary mb-2">New diagnosis</a>
        </c:if>

        <c:if test="${not empty diagnoses}">
            <div>Diagnoses:</div>
            <ul>
                <c:forEach items="${diagnoses}" var="diagnosis">
                    <li>
                        Name: ${diagnosis.name} | Date: <fmt:formatDate type="date" pattern="yyyy-MM-dd"
                                                                        value="${diagnosis.diagnosisDate}"/> | <a
                            href="/medical-case/${medicalCase.id}/diagnosis-details/${diagnosis.id}">Details</a> | <a
                            href="/medical-case/${medicalCase.id}/diagnosis/${diagnosis.id}">Edit</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <div><c:if test="${empty diagnoses}">Diagnoses: none</c:if></div>
    </div>

    <div class="separator">
        <c:if test="${not(medicalCase.caseStatus.name eq 'CANCELLED')}">
            <form method="post" action="/medical-case/${medicalCase.id}/upload" enctype="multipart/form-data">
                <div class="form-group">
                    <input class="form-control-file" type="file" name="file" id="file" onchange="checkFile()"/>
                    <input class="mt-2 btn btn-secondary" type="submit" value="Add attachment"/>
                </div>
            </form>
        </c:if>

        <c:if test="${empty pdfFiles}">Attachments: none</c:if>

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
    </div>
    <div class="separator">
        <a href="/patient-details/${medicalCase.patient.id}">To patient</a> |
        <a href="/medical-cases">To all medical cases</a>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/utils.js"/> "></script>

</body>
</html>
