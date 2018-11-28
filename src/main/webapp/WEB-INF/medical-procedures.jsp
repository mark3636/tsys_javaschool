<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Medical procedures</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
</head>
<body>
<div class="container">
    <c:import url="navbar.jsp"/>

    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" method="get" action="/medical-procedures">
            <input class="form-control mr-sm-2" type="search" name="patientName" value="${patientName}" placeholder="Patient's name" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="socialSecurityNumber" value="${socialSecurityNumber}" placeholder="Patient's SSN" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="caseNumber" value="${caseNumber}" placeholder="Medical case number" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <div class="mt-2">
        <c:if test="${!empty medicalProcedures}">
            <table class="table table-striped">
                <tr>
                    <th>Patient's name</th>
                    <th>Medical case number</th>
                    <th>Patient's birthday</th>
                    <th>Patient's SSN</th>
                    <th>Details</th>
                    <th>DONE</th>
                    <th>NOT DONE</th>
                </tr>
                <c:forEach items="${medicalProcedures}" var="medicalProcedure">
                    <tr>
                        <td>${medicalProcedure.medicalCase.patient.name}</td>
                        <td>${medicalProcedure.medicalCase.number}</td>
                        <td>${medicalProcedure.medicalCase.patient.birthday}</td>
                        <td>${medicalProcedure.medicalCase.patient.socialSecurityNumber}</td>
                        <td><a href="<c:url value='/procedure-details/${medicalProcedure.id}' />">Details</a></td>
                        <c:if test="${medicalProcedure.procedureStatus.name eq 'NEW'}">
                            <td><a href="#myModal" data-toggle="modal">DONE</a></td>
                            <td><a href="<c:url value='/medical-procedure/${medicalProcedure.id}/change?status=NOT_DONE' />">NOT DONE</a></td>
                        </c:if>
                        <c:if test="${not(medicalProcedure.procedureStatus.name eq 'NEW')}">
                            <td>-</td>
                            <td>-</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog modal-lg">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="form-group" style="margin: 10px">
                            <label for="comment">Comment</label>
                            <textarea class="form-control" name="comment" id="comment"
                                      placeholder="Comment"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default">Submit</button>
                            <button type="button" class="btn" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${empty medicalProcedures}">
            No medical procedures
        </c:if>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/resources/javascript/utils.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/bootstrap.min.js"/> "></script>
</body>
</html>
