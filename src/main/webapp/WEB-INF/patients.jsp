<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Patients</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" method="get" action="/patients" id="search">
            <input class="form-control mr-sm-2" type="search" name="surname" value="${surname}" placeholder="Surname"
                   aria-label="Search">
            <input class="form-control mr-sm-2" type="search" id="birthday" name="birthday" value="${birthday}"
                   placeholder="Birthday" aria-label="Search" readonly="readonly" style="background-color: white">
            <input class="form-control mr-sm-2" type="search" name="caseNumber" value="${caseNumber}"
                   placeholder="Medical case number" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
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
                        <td><a href="<c:url value='/remove/${patient.id}' />"
                               onclick="return confirmDelete(this, '${pageContext.request.contextPath}/remove/${patient.id}')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty listPatients}">
            No patients
        </c:if>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/utils.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/patients.js"/> "></script>

</body>
</html>
