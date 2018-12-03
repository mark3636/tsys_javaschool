<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New visit</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.timepicker.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form action="/patient-details/${patient.id}/new-visit" method="post" id="visit">
        <div class="form-group">
            <label for="medicalStaff">Medical staff</label>
            <form:select path="medicalStaff" name="medicalStaffId" id="medicalStaff" cssClass="form-control">
                <c:forEach items="${medicalStaff}" var="staff">
                    <form:option value="${staff.id}" label="${staff.role.alias} ${staff.name} ${staff.surname}"/>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="visitDate">Visit date</label>
            <input class="form-control" type="text" placeholder="Visit date" id="visitDate" name="visitDate"
                   value="${visit.visitDate}" readonly="readonly" style="background-color: white"
                   onchange="getBeginningTime(${patient.id})">
        </div>

        <div class="form-group">
            <label for="beginningTime">Beginning time</label>
            <input class="form-control" id="beginningTime" type="text" name="beginningTime" disabled
                   placeholder="Beginning time" onchange="getEndingTime(${patient.id})"/>
        </div>

        <div class="form-group">
            <label for="endingTime">Ending time</label>
            <input class="form-control" id="endingTime" name="endingTime" disabled type="text"
                   placeholder="Ending time" onchange="readyForSubmit()"/>
        </div>

        <div>
            <input id="submitBtn" class="btn btn-primary" type="submit" value="Add visit" disabled>
            <a href="/patient-details/${patient.id}">Back</a>
        </div>
    </form>

    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.timepicker.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/visit.js"/> "></script>
</div>
</body>
</html>
