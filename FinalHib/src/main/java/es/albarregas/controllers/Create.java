package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.ITutorDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.models.DateConverter;
import es.albarregas.models.EnumConverter;
import es.albarregas.models.Utils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

/**
 *
 * @author sarap
 */
@WebServlet(name = "Create", urlPatterns = {"/Create"})
public class Create extends HttpServlet {

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
        ITutorDAO tdao = daof.getTutorDAO();
        Enumeration<String> parametros = request.getParameterNames();
        Tutor tutor = null;
        Alumno alumno = null;
        Ciclo ciclo = null;
        String aviso = "";
        String url = "JSP/home.jsp";

        if (request.getParameter("altaTutor") != null) {
            aviso = Utils.comprobarCampos(parametros, request, "");
            if (aviso.isEmpty()) {
                tutor = new Tutor();
                try {
                    String idCiclo = request.getParameter("idCiclo");
                    Tutor tutorExistente = tdao.comprobarTutorCiclo(idCiclo);
                    if (tutorExistente == null) {
                        BeanUtils.populate(tutor, request.getParameterMap());
                        ciclo = (Ciclo) gdao.getById(idCiclo, Ciclo.class);
                        tutor.setCiclo(ciclo);
                        tutor.setRol(Tutor.Rol.TUTOR);
                        String passwordEncriptado = Utils.encriptarPassword("123");
                        tutor.setPassword(passwordEncriptado);
                        gdao.insertOrUpdate(tutor);
                        request.getSession().removeAttribute("ciclos");
                    } else {
                        aviso = "Ya existe un tutor asignado a este ciclo.";
                        url = "JSP/CREATE/crearTutor.jsp";
                    }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                url = "JSP/CREATE/crearTutor.jsp";
            }
        }

        if (request.getParameter("altaAlumno") != null) {
            aviso = Utils.comprobarCampos(parametros, request, "");
            if (aviso.isEmpty()) {
                alumno = new Alumno();
                try {
                    ConvertUtils.register(new DateConverter(), java.util.Date.class);
                    ConvertUtils.register(new EnumConverter(), Alumno.Genero.class);
                    BeanUtils.populate(alumno, request.getParameterMap());
                    tutor = (Tutor) request.getSession().getAttribute("usuario");
                    alumno.setCiclo(tutor.getCiclo());
                    String passwordEncriptado = Utils.encriptarPassword("123");
                    alumno.setPassword(passwordEncriptado);
                    alumno.setRol(Usuario.Rol.ALUMNO);
                    gdao.insertOrUpdate(alumno);
                    url = "JSP/home.jsp";

                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                url = "JSP/CREATE/crearAlumno.jsp";
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
