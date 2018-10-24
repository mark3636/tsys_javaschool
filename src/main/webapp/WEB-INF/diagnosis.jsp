<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Diagnosis</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>
    <form action="/medical-case/${medicalCase.id}/diagnosis" method="post">
        <c:if test="${diagnosis.id != 0}">
        <div>
            <input class="form-control" type="hidden" name="id" placeholder="name" value="${diagnosis.id}"/>
        </div>
        </c:if>
        <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" type="text" id="name" name="name" placeholder="name" value="${diagnosis.name}"/>
        </div>
        <div class="form-group">
            <label for="comment">Comment</label>
            <input class="form-control" type="text-area" id="comment" name="comment" placeholder="comment"
                   value="${diagnosis.comment}">
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
</body>
</html>