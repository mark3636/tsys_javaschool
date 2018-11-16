<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/> ">
</head>
<body class="login-bg">
<div class="wrapper">
    <div class="form-signin">
        <form action="/login" method="post">
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
            <input type="text" class="form-control" name="email" placeholder="Email address" required="" autofocus=""/>
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
            <div class="form-actions">
                <input type="submit"
                       class="btn btn-block btn-primary btn-default" value="Log in">
            </div>
        </form>
        <a href="<c:url value="/registration"/>">Registration</a>
    </div>
</div>
</body>
