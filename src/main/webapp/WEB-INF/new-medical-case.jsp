<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New medical case</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form action="/patient-details/${patient.id}/new-medical-case" method="post" id="medicalCase">

        <div class="form-group">
            <label for="number">Number (10 characters)</label>
            <input class="form-control" type="text" id="number" name="number" placeholder="Number"
                   value="${medicalCase.number}"/>
        </div>

        <div class="form-group">
            <label for="medicalStaff">Medical staff</label>
            <form:select path="medicalStaff" name="medicalStaffId" id="medicalStaff" cssClass="form-control">
                <c:forEach items="${medicalStaff}" var="staff">
                    <form:option value="${staff.id}" label="${staff.role.alias} ${staff.name} ${staff.surname}"/>
                </c:forEach>
            </form:select>
        </div>

        <div>
            <input class="btn btn-primary" type="submit"
                   value="<spring:message text="Add"/>"/>
            <a href="/patient-details/${patient.id}">Back</a>
        </div>
    </form>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/medical-case.js"/> "></script>

</body>
</html>
