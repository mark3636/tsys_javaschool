<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical procedure</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <form action="/medical-case/${medicalCase.id}/medical-procedure" method="post" id="medical-procedure">
        <c:if test="${medicalProcedure.id != 0}">
        <div>
            <input class="form-control" type="hidden" name="id" value="${medicalProcedure.id}"/>
        </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" id="name" name="name" placeholder="Name"
                   value="${medicalProcedure.name}"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description"
                      placeholder="Description"><c:out value="${medicalProcedure.description}"/></textarea>
        </div>
        <div>
            <c:if test="${medicalProcedure.id != 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Edit"/>"/>
            </c:if>
            <c:if test="${medicalProcedure.id == 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Add"/>"/>
            </c:if>
            <a href="/medical-case/${medicalCase.id}">Back</a>
        </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/medical-procedure.js"/> "></script>

</body>
</html>