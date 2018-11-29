<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<security:authorize access="hasRole('DOCTOR')" var="isDoctor"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light mb-2">
    <a class="navbar-brand" href="/">Medical institute</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${isDoctor}">
                <li class="nav-item">
                    <a class="nav-link" href="/patients">Patients</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/medical-cases">Medical cases</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="/medical-procedures">Medical procedures</a>
            </li>
            <c:if test="${isDoctor}">
                <li class="nav-item">
                    <a class="nav-link" href="/medical-staff">Medical staff</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
