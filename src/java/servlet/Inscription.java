/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import DB.*;

/**
 *
 * @author sacha
 */
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

    
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
        
        // Initialisation des variables
        String nom, prenom, sexe, ddn, login, mdp, mdp2;
        float poids, taille;
        
        // Récupération des données
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        sexe = request.getParameter("sexe");
        ddn = request.getParameter("ddn");
        poids = Float.parseFloat(request.getParameter("poids"));
        taille = Float.parseFloat(request.getParameter("taille"));
        login = request.getParameter("login");
        mdp =request.getParameter("mdp");
        mdp2 =request.getParameter("mdp2");
        
        // Récupération des requêtes a exécuter sur la base de données
        //DataAccessObject dao = new DataAccessObject(getDataSource());
        
        // Exécution de la requête
        
        // Une fois bien inséré redirection sur la page de connexion
        
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
