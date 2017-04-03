/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import DB.*;
import javax.enterprise.context.SessionScoped;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sacha
 */
@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

    
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
        
        try {
            boolean rs;
            // Récupère l'identifiant de l'utilisateur
            String login = request.getParameter("login");
            // Récupère le mot de passe
            String mdp = request.getParameter("mdp");
            
            // Récupère la Connexion à la base de données
            DataAccessObject dao = new DataAccessObject(getDataSource());
            
            // Recherche l'utilisateur dans la base de données
            rs = dao.utilisateurConnect(login, mdp);
            
            if (rs) {
                // On démarre une session pour l'utilisateur
                HttpSession session = request.getSession(true);
                // On donne le nom de l'utilisateur à la session
                session.setAttribute("nom", login);
                
                // La personne existe on peut aller sur la page d'acceuil
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                // Erreur on retourne saisir login + mdp
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
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
