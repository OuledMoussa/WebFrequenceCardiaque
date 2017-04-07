/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author sacha
 */
public class DataAccessObject {

    private final DataSource myDataSource;

    /**
     *
     * @param dataSource la source de données à utiliser
     */
    public DataAccessObject(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    /**
     * Récupère le mot de passe de l'utilisateur
     */
    public boolean utilisateurConnect(String utilisateur,
            String mdp) {

        int test = 0;
        // Requête à exécuter
        String rq = "select login_personne, mdp_personne "
                + "from personne where login_personne = ?"
                + "and mdp_personne = ?";

        // Connection à la base et création du statement
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            // Ajoute les valeurs de la clause Where
            ps.setString(1, utilisateur);
            ps.setString(2, mdp);

            // Execute la requête
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                test++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test == 1;
    }

    public void nouveauUtilisateur(String nom, String prenom, String ddn, float taille, float poids, String sexe, String login, String mdp) {

        String query;

        query = "insert into personne(nom_personne, prenom_personne, "
                + "date_naissance, taille_personne, poids_personne, "
                + "sexe_personne, login_personne, mdp_personne)"
                + "values(?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?)";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(query)) {
            // Insère les données collectées par la servlet Inscription
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, ddn);
            ps.setFloat(4, taille);
            ps.setFloat(5, poids);
            ps.setString(6, sexe);
            ps.setString(7, login);
            ps.setString(8, mdp);
            ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MedFolderEntity getDossierMedical(int id_personne) {
        MedFolderEntity result = null;
        int idFolder;
        float tMax;
        float tMin;
        boolean smoke;
        boolean hta;
        boolean diabete;
        int idPerson;

        String rq;

        rq = "Select * "
                + "From dossiermedical "
                + "Where dossiermedical.id_personne = ? ";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            // Insère le numéro de la personne dans la requête
            ps.setInt(1, id_personne);
            
            try (ResultSet rs = ps.executeQuery()) {

                idFolder = rs.getInt("idFolder");
                tMax = rs.getFloat("tMax");
                tMin = rs.getFloat("tMin");
                smoke = rs.getBoolean("smoke");
                hta = rs.getBoolean("hta");
                diabete = rs.getBoolean("diabete");
                idPerson = rs.getInt("idPerson");

                result = new MedFolderEntity(idFolder, tMax, tMin, smoke,
                        hta, diabete, idPerson);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public PersonEntity getInfoPerson(int id_personne) {
        PersonEntity result = null;
        int id;
        String nom;
        String prenom;
        String date;
        float taille;
        float poids;
        String login;
        String password;

        String rq = "Select * "
                + "From personne "
                + "Where peronne.id_personne = ? ";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            ps.setInt(1, id_personne);
            
            try (ResultSet rs = ps.executeQuery()) {
                // Récupère les données de la BD
                id = rs.getInt("id");
                nom = rs.getString("nom");
                prenom = rs.getString("prenom");
                date = rs.getString("date");
                taille = rs.getFloat("taille");
                poids = rs.getFloat("poids");
                login = rs.getString("login");
                password = rs.getString("password");

                result = new PersonEntity(id, nom, prenom, date,
                        taille, poids, login, password);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void updateInfoPerson(int id_personne, String nom, String prenom, String ddn, float taille, float poids, String sexe, String login, String mdp) throws SQLException {
                
        String rq = "update personne set nom_personne = ?, prenom_personne = ?, date_naissance = ?, taille_personne = ?, sexe_personne = ? where id_personne = ?";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {
            
            // Insère les données à modifier de la personne dans la requête
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, ddn);
            ps.setFloat(4, taille);
            ps.setFloat(5, poids);
            ps.setString(6, sexe);
            ps.setString(7, login);
            ps.setString(8, mdp);
            
            
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
