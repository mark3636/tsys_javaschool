<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Patients</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" method="get" action="/patients">
            <input class="form-control mr-sm-2" type="search" name="surname" value="${surname}" placeholder="Surname" aria-label="Search">
            <input class="form-control mr-sm-2" type="date" name="birthday" value="${birthday}" placeholder="Birthday" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="caseNumber" value="${caseNumber}" placeholder="Medical case number" aria-label="Search">
            <button class="btn btn-outline-success <%--my-2 my-sm-0--%> float-right" type="submit">Search</button>
        </form>
    </nav>

    <a href="/patient" class="mt-2 btn btn-primary">
        Add Patient
    </a>

    <div class="mt-2">
        <c:if test="${!empty listPatients}">
            <table class="table table-striped">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Social security number</th>
                    <th>Phone number</th>
                    <th>Details</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${listPatients}" var="patient">
                    <tr>
                        <td>${patient.name}</td>
                        <td>${patient.surname}</td>
                        <td>${patient.socialSecurityNumber}</td>
                        <td>${patient.phoneNumber}</td>
                        <td><a href="<c:url value='/patient-details/${patient.id}' />">Details</a></td>
                        <td><a href="<c:url value='/patient/${patient.id}' />">Edit</a></td>
                        <td><a href="<c:url value='/remove/${patient.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty listPatients}">
            No patients
        </c:if>
    </div>
</div>
</body>
</html>
