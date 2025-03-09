<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Alta tutor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="SCRIPTS/scriptEmail.js" defer></script>
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/INC/nav.jsp"/>
        <div class="container mt-5 flex-grow-1">
            <div class="row">
                <div class="col">
                    <form action="${contexto}/Create" method="POST">
                        <h1>Datos del tutor</h1>
                        <div class="form-floating mb-3">
                            <input type="email" name="email" class="form-control" id="inputEmail" value="${param.email}">
                            <label for="inputEmail">Email*</label>
                            <p id="correoExistente" class="text-danger"></p>
                        </div>
                        <div class="form-floating">
                            <select class="form-select" name="idCiclo" id="floatingSelect" aria-label="Floating label select example">
                                <c:forEach var="ciclo" items="${sessionScope.ciclos}">
                                    <option value="${ciclo.idCiclo}">${ciclo.nombre}</option>
                                </c:forEach>
                            </select>
                            <label for="floatingSelect">Ciclo</label>
                        </div>
                        <p class="text-danger">${requestScope.aviso}</p> 
                        <input class="btn btn-primary" id="btnRegistrar" type="submit" name="altaTutor" value="Enviar">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/INC/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
