<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Modificar datos alumno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="SCRIPTS/scriptEmail.js" defer></script>
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <form action="${contexto}/Update" method="POST">
                        <h1>Datos del alumno</h1>
                        <div class="form-floating mb-3">
                            <input type="text" name="nombre" class="form-control" id="floatingInput" value="${sessionScope.usuario.nombre}">
                            <label for="floatingInput">Nombre*</label>
                        </div>
                        <div class="form-floating mb-3" id="inputDiv">
                            <input type="text" name="apellidos" class="form-control" id="floatingApellidos"value="${sessionScope.usuario.apellidos}">
                            <label for="floatingApellidos">Apellidos*</label>
                        </div>
                        <div class="form-floating mb-3" id="inputDiv">
                            <input type="text" name="dni" class="form-control" id="floatingDNI"value="${sessionScope.usuario.dni}">
                            <label for="floatingDNI">DNI*</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" name="genero" id="floatingSelect" aria-label="Floating label select example">
                                <option value="">Elige genero...</option>
                                <option value="HOMBRE">Hombre</option>
                                <option value="MUJER">Mujer</option>
                                <option value="OTRO">Otro</option>
                            </select>
                            <label for="floatingSelect">Genero</label>
                        </div>
                        <div class="form-floating mb-3" id="inputDiv">
                            <input type="date" name="fechaNacimiento" class="form-control" id="floatingDNI"value="${sessionScope.usuario.fechaNacimiento}">
                            <label for="floatingDNI">Fecha de nacimiento*</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" name="nuevaPassword" class="form-control" id="floatingInput" value="">
                            <label for="floatingInput">Nueva Contraseña*</label>
                        </div>
                        <p class="text-danger">${requestScope.aviso}</p> 
                        <input class="btn btn-primary" id="btnRegistrar" type="submit" name="updateAlumno" value="Enviar">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/INC/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
