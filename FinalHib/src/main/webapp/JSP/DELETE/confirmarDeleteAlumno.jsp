<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Confirmacion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <form action="${contexto}/Delete" method="POST">
                        <h1>Alumno que va a eliminar</h1>
                        <table class="table">
                            <thead class="table-dark">
                            <td>Nombre</td>
                            <td>Apellidos</td>
                            <td>DNI</td>
                            <td>Email</td>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${sessionScope.alumno.nombre}</td>
                                    <td>${sessionScope.alumno.apellidos}</td>
                                    <td>${sessionScope.alumno.dni}</td>
                                    <td>${sessionScope.alumno.email}</td>
                                </tr>
                            </tbody>
                        </table> 
                        <input class="btn btn-primary" type="submit" name="confirmarAlumno" value="Confirmar">
                        <input class="btn btn-danger" type="submit" name="denegar" value="Denegar">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/INC/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
