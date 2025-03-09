package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Tutor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarap
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

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
        String url = "JSP/home.jsp";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        Tutor tutor = null;
        Alumno alumno = null;

        if (request.getParameter("deleteTutor") != null) {
            url = "JSP/DELETE/confirmarDeleteTutor.jsp";
            int id = Integer.parseInt(request.getParameter("tutores"));
            tutor = (Tutor) gdao.getById(id, Tutor.class);
            request.getSession().setAttribute("tutor", tutor);
        }

        if (request.getParameter("confirmarTutor") != null) {
            tutor = (Tutor) request.getSession().getAttribute("tutor");
            gdao.delete(tutor);
            request.getSession().removeAttribute("tutor");
        }

        if (request.getParameter("deleteAlumno") != null) {
            url = "JSP/DELETE/confirmarDeleteAlumno.jsp";
            int id = Integer.parseInt(request.getParameter("alumnos"));
            alumno = (Alumno) gdao.getById(id, Alumno.class);
            request.getSession().setAttribute("alumno", alumno);
        }
        
        if(request.getParameter("confirmarAlumno") != null) {
            alumno = (Alumno) request.getSession().getAttribute("alumno");
            gdao.delete(alumno);
            request.getSession().removeAttribute("alumno");
        }

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
