<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Listado de tutores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <h1>Listado de tutores</h1>
                    <table class="table">
                        <c:set var="nombre" value="" />
                        <c:forEach var="tutor" items="${requestScope.tutoresalumnos}">
                            <c:if test="${empty nombre || nombre != tutor[0].nombre}">
                                <thead class="table-dark">
                                    <tr>
                                        <td>Nombre tutor</td>
                                        <td>Apellido tutor</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${tutor[0].nombre}</td>
                                        <td>${tutor[0].apellidos}</td>
                                    </tr>
                                    <tr class="table-secondary">
                                        <td>Nombre alumno</td>
                                        <td>Apellido alumno</td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td>${tutor[1].nombre}</td>
                                    <td>${tutor[1].apellidos}</td>
                                </tr>
                                <c:set var="nombre" value="${tutor[0].nombre}" />
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
