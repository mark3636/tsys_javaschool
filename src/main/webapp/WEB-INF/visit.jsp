<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New visit</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/classic.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.10.2.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.mousewheel.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jQAllRangeSliders-min.js"/> "></script>
    <script>
        $("#slider").dateRangeSlider(
            "option",
            {
                bounds: {
                    min: new Date(2012, 1, 1),
                    max: new Date(2012, 1, 1)
                },
                enabled: false
            }
        );
    </script>

    <form action="/patient-details/${patient.id}/new-visit" method="post">
        <div class="form-group">
            <label for="medicalStaff">Medical staff</label>
            <form:select path="medicalStaff" name="medicalStaffId" id="medicalStaff" cssClass="form-control">
                <c:forEach items="${medicalStaff}" var="staff">
                    <form:option value="${staff.id}" label="${staff.name} ${staff.surname}"/>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="visitDate">Visit date</label>
            <input class="form-control" type="date" id="visitDate" name="visitDate" value="${visit.visitDate}">
        </div>

        <div class="form-group">
            <label for="beginningTime">Beginning time</label>
            <input class="form-control" type="time" id="beginningTime" name="beginningTime" value="${visit.visitDate}">
        </div>

        <div class="form-group">
            <label for="endingTime">Ending time</label>
            <input class="form-control" type="time" id="endingTime" name="endingTime" value="${visit.visitDate}">
        </div>

        <div id="slider"></div>

        <input type="submit" value="Add visit">
    </form>
</div>
</body>
</html>
