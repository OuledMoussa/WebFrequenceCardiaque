/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DB.DataAccessObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Permet d'ajouter les données au dossier médical de la personne qui s'est inscrite
 * et qui n'a pas encore rentré de données
 * @author sacha
 */
@WebServlet(name = "AjoutDossier", urlPatterns = {"/AjoutDossier"})
public class AjoutDossier extends HttpServlet {

    /**
     * Permet la connexion à la base de données
     *
     * @return la connexion à la BD
     * @throws SQLException Erreur lors de la connexion
     */
    public DataSource getDataSource() throws SQLException {
        oracle.jdbc.pool.OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
        ds.setDriverType("thin");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setDatabaseName("xe");
        // The host on which Network Server is running
        ds.setServerName("localhost");
        // port on which Network Server is listening
        ds.setPortNumber(1521);
        return ds;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Récupère la session de l'administrateur
            HttpSession session = request.getSession(true);
            
            // Récupère les paramètres de la requête
            String fume = request.getParameter("fumeur");
            String hta = request.getParameter("hta");
            String diabete = request.getParameter("diabete");
            Float min = Float.parseFloat(request.getParameter("smin"));
            Float max = Float.parseFloat(request.getParameter("smax"));
            int id = Integer.parseInt(session.getAttribute("id").toString());
            
            // Traitement des valeurs reçues
            if (fume == null) {
                fume = "false";
            } else {
                fume = "true";
            }
            if (hta == null) {
                hta = "false";
            } else {
                hta = "true";
            }
            if (diabete == null) {
                diabete = "false";
            } else {
                diabete = "true";
            }
            
            // Récupère les méthodes du DAO
            DataAccessObject dao = new DataAccessObject(getDataSource());
            
            // Exécute la requete de modification des données
            dao.AjoutDossier(id, fume, hta, diabete, min, max);
            
            // Retour sur la page classique de modification du 
            request.getRequestDispatcher("dossiermedical.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutDossier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
