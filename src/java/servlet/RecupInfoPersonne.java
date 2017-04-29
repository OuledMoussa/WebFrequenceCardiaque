/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DB.DataAccessObject;
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
 *
 * @author sacha
 */
@WebServlet(name = "RecupInfoPersonne", urlPatterns = {"/RecupInfoPersonne"})
public class RecupInfoPersonne extends HttpServlet {

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
            throws ServletException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        // Tableau des données qui seront envoyées au dao
        String[][] tab = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
        // Numéro de ligne du tableau
        int lg = 0;
        // Numéro de indice de colonne du tableau
        int col = 0;
        // récupère les paramètres
        String sexe = request.getParameter("sexe");
        String ddn = request.getParameter("ddn");
        String taille = request.getParameter("taille");
        String poids = request.getParameter("poids");
        String mail = request.getParameter("mail");
        String identifiant = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        
        // Ajoute les éléments qui doivent être rentrés dans la base de données
        if (sexe != null) {
            tab[col][lg] = "sexe";
            if (sexe == "Homme") {
                tab[col+1][lg] = "H";
            } else {
                tab[col+1][lg] = "F";
            }
            lg++;
        }
        if (ddn != null) {
            tab[col][lg] = "ddn";
            tab[col+1][lg] = ddn;
            lg++;
        }
        if (taille != null) {
            tab[col][lg] = "taille";
            tab[col+1][lg] = taille;
            lg++;
        }
        if (poids != null) {
            tab[col][lg] = "poids";
            tab[col+1][lg] = poids;
            lg++;
        }
        if (mail != null) {
            tab[col][lg] = "mail";
            tab[col+1][lg] = mail;
            lg++;
        }
        if (identifiant != null) {
            tab[col][lg] = "login";
            tab[col+1][lg] = identifiant;
            lg++;
        }
        if (mdp != null) {
            tab[col][lg] = "mdp";
            tab[col+1][lg] = mdp;
            lg++;
        }        
        
        // Récupère la session de l'administrateur
        HttpSession session = request.getSession(true);
        
        int id = Integer.parseInt(session.getAttribute("id").toString());
        
        // Récupère les méthodes du DAO
        DataAccessObject dao = new DataAccessObject(getDataSource());
        
        // Envoi les modifications dans la base de données
        dao.modifCompte(tab, id);
        
        // La personne est renvoyé sur son compte pour voir si les modifications ont fonctionnées
        request.getRequestDispatcher("compte.jsp").forward(request, response);
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
            throws ServletException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RecupInfoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecupInfoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RecupInfoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecupInfoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
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
