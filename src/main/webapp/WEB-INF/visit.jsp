<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>New visit</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/classic.css"/> ">
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
            <input class="form-control" type="date" id="visitDate" name="visitDate" value="${visit.visitDate}">
        </div>

        <div class="form-group">
            <label for="beginningTime">Beginning time</label>
            <input class="form-control" min="9:00" max="16:50" type="time" id="beginningTime" name="beginningTime"
                   value="${visit.visitDate}">
        </div>

        <div class="form-group">
            <label for="endingTime">Ending time</label>
            <input class="form-control" min="9:10" max="17:00" type="time" id="endingTime" name="endingTime"
                   value="${visit.visitDate}">
        </div>

        <input class="btn btn-primary" type="submit" value="Add visit">
    </form>

    <a href="/patient-details/${patient.id}">Back</a>

    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.10.2.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery.mousewheel.min.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/jQAllRangeSliders-min.js"/> "></script>
    <script>
        $("#slider").rangeSlider(
            {
                bounds: {
                    min: 540,
                    max: 780
                },
                formatter: function (val) {
                    var hours = Math.floor(val / 60)
                    var minutes = Math.floor(val % 60)

                    return hours + ":" + minutes.toLocaleString(undefined, {minimumIntegerDigits: 2})
                },
                step: 10,
                range: {
                    min: 10,
                    max: 30
                }
            }
        );
    </script>
</div>
</body>
</html>
