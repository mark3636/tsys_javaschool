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
        <form class="form-inline" method="get" action="/medical-procedures" style="margin-bottom: 0">
            <input class="form-control mr-sm-2" type="search" name="patientName" value="${patientName}"
                   placeholder="Patient name" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="socialSecurityNumber"
                   value="${socialSecurityNumber}" placeholder="Patient SSN" aria-label="Search">
            <input class="form-control mr-sm-2" type="search" name="caseNumber" value="${caseNumber}"
                   placeholder="Medical case number" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <div class="mt-2">
        <c:if test="${!empty medicalProcedures}">
            <table class="table table-striped">
                <tr>
                    <th>Procedure name</th>
                    <th>Patient name</th>
                    <th>Patient SSN</th>
                    <th>Medical case number</th>
                    <th>Patient birthday</th>
                    <th>Details</th>
                    <th>DONE</th>
                    <th>NOT DONE</th>
                </tr>
                <c:forEach items="${medicalProcedures}" var="medicalProcedure">
                    <c:if test="${not (medicalProcedure.medicalCase.caseStatus.name eq 'CANCELLED')}">
                        <tr id="tr-${medicalProcedure.id}">
                            <td>${medicalProcedure.name}</td>
                            <td>${medicalProcedure.medicalCase.patient.socialSecurityNumber}</td>
                            <td>${medicalProcedure.medicalCase.patient.name} ${medicalProcedure.medicalCase.patient.surname}</td>
                            <td>${medicalProcedure.medicalCase.number}</td>
                            <td>${medicalProcedure.medicalCase.patient.birthday}</td>
                            <td><a href="<c:url value='/procedure-details/${medicalProcedure.id}' />">Details</a></td>
                            <c:if test="${medicalProcedure.procedureStatus.name eq 'NEW'}">
                                <td><a onclick="changeStatus(${medicalProcedure.id}, 'DONE')"
                                       id="${medicalProcedure.id}"
                                       class="cl1" href="#myModal" data-toggle="modal">DONE</a></td>
                                <td><a onclick="changeStatus(${medicalProcedure.id}, 'NOT_DONE')"
                                       id="${medicalProcedure.id}" class="cl1" href="#myModal" data-toggle="modal">NOT
                                    DONE</a></td>
                            </c:if>
                            <c:if test="${medicalProcedure.procedureStatus.name eq 'DONE'}">
                                <td>+</td>
                                <td>-</td>
                            </c:if>
                            <c:if test="${medicalProcedure.procedureStatus.name eq 'NOT_DONE'}">
                                <td>-</td>
                                <td>+</td>
                            </c:if>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog modal-lg">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="form-group" style="margin: 10px">
                            <label for="comment">Enter your comment</label>
                            <textarea class="form-control" name="comment" id="comment"
                                      placeholder="Comment"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button id="submit" type="submit" class="btn btn-primary" data-dismiss="modal">Submit
                            </button>
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

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/medical-procedures.js"/> "></script>

</body>
</html>
