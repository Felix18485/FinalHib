<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application" />
<c:url var="estilo" value="/CSS/styles.css" scope="application" />
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Página Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Practica Final</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

        <div class="container d-flex justify-content-center align-items-center" style="height: 80vh;">
            <div class="card p-4 shadow" style="width: 350px;">
                <h3 class="text-center">Iniciar Sesión</h3>
                <form action="${contexto}/FrontController" method="POST">
                    <div class="mb-3">
                        <label class="form-label">Correo Electrónico</label>
                        <input type="email" name="correo" class="form-control" placeholder="usuario@correo.com">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Contraseña</label>
                        <input type="password" name="password" class="form-control" placeholder="">
                    </div>
                    <p class="text-danger">${requestScope.aviso}</p>
                    <button type="submit" name="login" class="btn btn-primary w-100">Enviar</button>
                </form>
            </div>
        </div>

        <footer class="bg-dark text-white text-center py-3 mt-auto">
            <p class="mb-0">&copy; Practica Final Hibernate.</p>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
