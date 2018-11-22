<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New visit</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/classic.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.timepicker.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form action="/patient-details/${patient.id}/new-visit" method="post">
        <div class="form-group">
            <label for="medicalStaff">Medical staff</label>
            <form:select path="medicalStaff" name="medicalStaffId" id="medicalStaff" cssClass="form-control">
                <c:forEach items="${medicalStaff}" var="staff">
                    <form:option value="${staff.id}" label="Dr. ${staff.name} ${staff.surname}"/>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="visitDate">Visit date</label>
            <input class="form-control" type="date" id="visitDate" name="visitDate" value="${visit.visitDate}" onchange="getBeginningTime(${patient.id})">
        </div>

        <div class="form-group">
            <label for="beginningTime">Beginning time</label>
            <input class="form-control" id="beginningTime" type="text" name="beginningTime" disabled onchange="getEndingTime(${patient.id})"/>
        </div>

        <div class="form-group">
            <label for="endingTime">Ending time</label>
            <input class="form-control" id="endingTime" name="endingTime" disabled type="text" onchange="readyForSubmit()"/>
        </div>

        <input id="submitBtn" class="btn btn-primary" type="submit" value="Add visit" disabled>
    </form>

    <a href="/patient-details/${patient.id}">Back</a>

    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.timepicker.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/utils.js"/> "></script>
</div>
</body>
</html>
