package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Usuario;
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

/**
 *
 * @author sarap
 */
@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

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
        String url = "JSP/home.jsp";
        String aviso = "";
        Enumeration<String> parametros = request.getParameterNames();
        if (request.getParameter("updateTutor") != null || request.getParameter("updateAlumno") != null) {
            aviso = Utils.comprobarCampos(parametros, request, "");
            if (aviso.isEmpty()) {
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                try {
                    BeanUtils.populate(usuario, request.getParameterMap());
                    String nuevoPassword = Utils.encriptarPassword(request.getParameter("nuevaPassword"));
                    usuario.setPassword(nuevoPassword);
                    gdao.insertOrUpdate(usuario);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(request.getParameter("updateTutor") != null){
                url = "JSP/UPDATE/modificarDatosTutor.jsp";
            }else{
                url = "JSP/UPDATE/modificarDatosAlumno.jsp";
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
