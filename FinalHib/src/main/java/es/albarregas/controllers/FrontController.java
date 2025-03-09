package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.ITutorDAO;
import es.albarregas.DAO.IUsuarioDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.models.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarap
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        IUsuarioDAO udao = daof.getUsuarioDAO();
        ITutorDAO tdao = daof.getTutorDAO();
        Usuario usuario = null;
        Alumno alumno = null;
        List<Ciclo> ciclos = null;
        List<Tutor> tutores = null;
        List<Alumno> alumnos = null;
        String boton = request.getParameter("boton");
        String url = "JSP/home.jsp";
        String aviso = "";
        if (request.getParameter("login") != null) {
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            usuario = udao.comprobarUsuario(correo);
            if (usuario != null) {
                String passwordEncriptada = Utils.encriptarPassword(password);
                if (usuario.getPassword().equalsIgnoreCase(passwordEncriptada)) {
                    request.getSession().setAttribute("usuario", usuario);
                    if (usuario.getUltimoAcceso() == null) {
                        if (Usuario.Rol.TUTOR.equals(usuario.getRol())) {
                            url = "JSP/UPDATE/modificarDatosTutor.jsp";
                        } else {
                            url = "JSP/UPDATE/modificarDatosAlumno.jsp";
                        }
                        usuario.setUltimoAcceso(new Date());
                        gdao.insertOrUpdate(usuario);
                    }
                } else {
                    aviso = "La contraseña introduida es incorrecta";
                    url = ".";
                }
            } else {
                aviso = "El correo introducido no existe";
                url = ".";
            }
        }
        if (boton != null) {
            switch (boton) {
                case "Cerrar Sesion":
                    url = ".";
                    request.getSession().removeAttribute("usuario");
                    break;
                case "Alta tutor":
                    url = "JSP/CREATE/crearTutor.jsp";
                    ciclos = gdao.selectAll(Ciclo.class);
                    request.getSession().setAttribute("ciclos", ciclos);
                    break;
                case "Listado tutores":
                    url = "JSP/READ/listarTutores.jsp";
                    List<Object[]> tutoresalumnos = tdao.getTutoresAlumnos();
                    request.setAttribute("tutoresalumnos", tutoresalumnos);
                    break;
                case "Eliminar tutores":
                    url = "JSP/DELETE/deleteTutor.jsp";
                    tutores = tdao.getTutoresSinAlumnos();
                    request.setAttribute("tutores", tutores);
                    break;
                case "Modificar datos tutor":
                    url = "JSP/UPDATE/modificarDatosTutor.jsp";
                    break;
                case "Alta alumno":
                    url = "JSP/CREATE/crearAlumno.jsp";
                    break;
                case "Eliminar alumnos":
                    url = "JSP/DELETE/deleteAlumno.jsp";
                    alumnos = gdao.selectAll(Alumno.class);
                    request.setAttribute("alumnos", alumnos);
                    break;
                case "Modificar datos alumno":
                    url = "JSP/UPDATE/modificarDatosAlumno.jsp";
                    break;
                case "Ver modulos":
                    url = "JSP/READ/listadoModulos.jsp";  
                    alumno = (Alumno) request.getSession().getAttribute("usuario");
                    List<Object[]> tutorModulos = tdao.getTutorModulos(alumno.getCiclo());
                    request.setAttribute("tutorModulos", tutorModulos);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        request.setAttribute("aviso", aviso);
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
