<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Eliminar tutor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <h1>Selecciona el tutor que quiere eliminar</h1>
                    <form action="${contexto}/Delete" method="POST">
                        <table class="table">
                            <thead class="table-dark">
                            <td>Seleccionar</td>    
                            <td>Nombre</td>
                            <td>Apellidos</td>
                            </thead>
                            <tbody>
                                <c:set var="primero" value="false" />
                                <c:forEach var="tutor" items="${requestScope.tutores}">
                                    <tr class="align-middle">
                                        <td><input type="radio" value="${tutor.idUsuario}" name="tutores" ${primero == false ? "checked":""}></td>
                                        <td>${tutor.nombre}</td>
                                        <td>${tutor.apellidos}</td>
                                    </tr>
                                    <c:set var="primero" value="true" />
                                </c:forEach>
                            </tbody>
                        </table> 
                        <input class="btn btn-primary" type="submit" name="deleteTutor" value="Enviar">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/INC/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
