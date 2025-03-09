<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Listado de modulos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <h1>Listado de modulos</h1>
                    <table class="table">
                        <c:set var="tutor" value="false" />
                        <c:forEach var="modulo" items="${requestScope.tutorModulos}">
                            <c:if test="${tutor == false}">
                                <thead class="table-dark">
                                <td colspan="3">Tutor</td>
                                </thead>
                                <tbody>
                                <td colspan="3">${modulo[0].nombre} ${modulo[0].apellidos}</td>
                                <tr class="table-secondary">
                                <td>Familia</td>
                                <td>Curso</td>
                                <td>Modulo</td>
                            </tr>
                            </c:if>
                            <tr>
                                <td>${modulo[1] != null ? modulo[1] : "Sin familia"}</td>
                                <td>${modulo[2]}</td>
                                <td>${modulo[3]}</td>
                            </tr>
                            <c:set var="tutor" value="true" />
                        </c:forEach>
                        </tbody>
                    </table> 
                </div>
            </div>
        </div>

        <jsp:include page="/INC/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
