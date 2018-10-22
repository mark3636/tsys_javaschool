<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <div>
        <c:if test="${not empty error}">${error}</c:if>
    </div>
    <div>
        <label> Email : <input type="text" name="email"/> </label>
    </div>
    <div>
        <label> Password: <input type="password" name="password"/> </label>
    </div>
    <div>
        <input type="submit" value="Sign In"/>
    </div>
</form>
</body>
