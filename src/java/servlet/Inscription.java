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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String nom, prenom, sexe, ddn, login, mail, mdp;
        float poids, taille;
        // variables de date
        String jour, mois, an;
        
        // Récupération des données
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        sexe = request.getParameter("sexe");
        ddn = request.getParameter("ddn");
        poids = Float.parseFloat(request.getParameter("poids"));
        taille = Float.parseFloat(request.getParameter("taille"));
        mail = request.getParameter("mail");
        login = request.getParameter("login");
        mdp =request.getParameter("mdp");
        
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(sexe);
        System.out.println(ddn);
        System.out.println(poids);
        System.out.println(taille);
        System.out.println(mail);
        System.out.println(mdp);
        
        // Traitement des données recues
        // Traitement de la date
        String[] date = ddn.split("\\s"); // Filtre les espaces
        // Isole le jour
        jour = date[0];
        // Isole le mois
        mois = date[1];
        // Isole l'annéee
        an = date[2];
        
        // Traitment du jour
        if (jour.length() == 1) {
            jour = "0" + jour;
        }
        System.out.println(jour);
        // Traite le mois
        mois = mois.substring(0,mois.length()-1);
        mois = dateJour(mois);
        
        // Date Finale
        ddn = jour + "/" + mois + "/" + an;
        System.out.println("Date de naissance : " + ddn);
        // Traitement du mot de passe
        
        
        // Récupération des requêtes a exécuter sur la base de données
        DataAccessObject dao = null;
        try {
            dao = new DataAccessObject(getDataSource());
        } catch (SQLException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //dao.nouveauUtilisateur(nom, prenom, ddn, taille, poids, sexe, login, mdp);
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
    
    /**
     * Traduit le mois du texte en caractère
     * @param mois Le mois de l'année
     * @return le mois en chiffre
     */
    private String dateJour(String mois) {
        switch(mois) {
            case "January": 
                mois = "01";
                break;
            case "February": 
                mois = "02";
                break;
            case "March": 
                mois = "03";
                break;
            case "April": 
                mois = "04";
                break;
            case "May": 
                mois = "05";
                break;
            case "June": 
                mois = "06";
                break;
            case "July": 
                mois = "07";
                break;
            case "August": 
                mois = "08";
                break;
            case "September": 
                mois = "09";
                break;
            case "October": 
                mois = "10";
                break;
            case "November": 
                mois = "11";
                break;
            case "December": 
                mois = "12";
                break;
        }
        return mois;
    }
}
