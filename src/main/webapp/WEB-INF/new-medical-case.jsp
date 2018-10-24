<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New medical case</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <form action="/patient-details/${patient.id}/new-medical-case" method="post">

        <div class="form-group">
            <label for="number">Number</label>
            <input class="form-control" type="text" id="number" name="number" placeholder="number"
                   value="${medicalCase.number}"/>
        </div>

        <div class="form-group">
            <label for="medicalStaff">Medical staff</label>
            <form:select path="medicalStaff" name="medicalStaffId" id="medicalStaff" cssClass="form-control">
                <c:forEach items="${medicalStaff}" var="staff">
                    <form:option value="${staff.id}" label="${staff.name} ${staff.surname}"/>
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
</body>
</html>
