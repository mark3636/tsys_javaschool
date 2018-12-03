<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Diagnosis</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <form action="/medical-case/${medicalCase.id}/diagnosis" method="post" id="diagnosis">
        <c:if test="${diagnosis.id != 0}">
        <div>
            <input class="form-control" type="hidden" name="id" placeholder="name" value="${diagnosis.id}"/>
        </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" id="name" name="name" placeholder="Name" value="${diagnosis.name}"/>
        </div>
        <div class="form-group">
            <label for="comment">Comment</label>
            <textarea class="form-control" type="text-area" id="comment" name="comment" placeholder="Comment"><c:out
                    value="${diagnosis.comment}"/></textarea>
        </div>
        <div>
            <c:if test="${diagnosis.id != 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Edit"/>"/>
            </c:if>
            <c:if test="${diagnosis.id == 0}">
                <input class="btn btn-primary" type="submit"
                       value="<spring:message text="Add"/>"/>
            </c:if>
            <a href="/medical-case/${medicalCase.id}">Back</a>
        </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.validate.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/diagnosis.js"/> "></script>

</body>
</html>