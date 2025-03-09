<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${contexto}/FrontController">Practica Final</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <form action="${contexto}/FrontController" method="POST">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <input class="nav-link active" type="submit" name="inicio" value="Inicio">
                    </li>
                    <c:if test="${sessionScope.usuario.rol == 'ADMIN'}">
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Alta tutor">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Listado tutores">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Eliminar tutores">
                        </li>

                        <!-- <li class="nav-item dropdown">
                             <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                 Eliminar
                             </a>
                             <ul class="dropdown-menu">
                                 <li><input type="submit" name="boton" class="dropdown-item" value="Eliminar ciclo"></li>
                                 <li><input type="submit" name="boton" class="dropdown-item" value="Eliminar modulo"></li>  
                             </ul>
                         </li> -->
                    </c:if>
                    <c:if test="${sessionScope.usuario.rol == 'TUTOR'}">
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Alta alumno">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Listado alumnos">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Modificar notas">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Eliminar alumnos">
                        </li>
                        <li class="nav-item">
                            <input class="nav-link" type="submit" name="boton" value="Modificar datos tutor">
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.usuario.rol == 'ALUMNO'}">
                        <input class="nav-link" type="submit" name="boton" value="Modificar datos alumno">
                        <input class="nav-link" type="submit" name="boton" value="Ver notas">
                        <input class="nav-link" type="submit" name="boton" value="Ver modulos">
                    </c:if>
                    <li class="nav-item">
                        <input class="nav-link" type="submit" name="boton" value="Cerrar Sesion">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</nav>