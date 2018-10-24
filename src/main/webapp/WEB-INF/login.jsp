<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/login" method="post">
        <div class="input-group input-sm">
            <label class="input-group-addon" for="email"><i class="fa fa-user"></i></label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Enter email" required>
        </div>
        <div class="input-group input-sm">
            <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password"
                   required>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-actions">
            <input type="submit"
                   class="btn btn-block btn-primary btn-default" value="Log in">
        </div>
    </form>
</div>
</body>
