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
    public PersonEntity utilisateurConnect(String utilisateur,
            String mdp) {
        // Personne qui se connecte
        PersonEntity personne = null;
        // Requête à exécuter
        String rq = "SELECT id_personne, nom_personne, login_personne, mdp_personne "
                + "FROM personne WHERE login_personne = ?"
                + "AND mdp_personne = ?";

        // Connection à la base et création du statement
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            // Ajoute les valeurs de la clause Where
            ps.setString(1, utilisateur);
            ps.setString(2, mdp);

            // Execute la requête
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                personne = new PersonEntity(rs.getInt(1), rs.getString(2));                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personne;
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

    /**
     * Donne le dossier médical du patient
     * @param id_personne
     * @return MedFolderEntity Le dossier médical de la perssone
     * @throws SQLException 
     */
    public MedFolderEntity getDossierMedical(int id_personne) {
        MedFolderEntity result = null;
        int idFolder;
        float tMax;
        float tMin;
        String smoke;
        String hta;
        String diabete;
        int idPerson;

        String rq;

        rq = "SELECT *"
                + "FROM dossiermedical "
                + "WHERE dossiermedical.id_personne = ? ";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            // Insère le numéro de la personne dans la requête
            ps.setInt(1, id_personne);
            
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                
                idFolder = rs.getInt(1);
                tMax = rs.getFloat(2);
                tMin = rs.getFloat(3);
                smoke = rs.getString(4);
                hta = rs.getString(5);
                diabete = rs.getString(6);
                idPerson = rs.getInt(7);

                
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

        String rq = "SELECT * "
                + "FROM personne "
                + "WHERE peronne.id_personne = ? ";

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
                
        String rq = "UPDATE personne SET nom_personne = ?, prenom_personne = ?, "
                + "date_naissance = ?, taille_personne = ?, sexe_personne = ? "
                + "WHERE id_personne = ?";
        
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
    
    
    /**
     * 
     */
    public List<EnrEntity> frequenceFQ(int id_personne) throws SQLException {
        // Requête qui récupère uniquement la date, la fréquence et les seuils du médecin        
        String rq = "SELECT enr.date_enregistrement, enr.frequence_cardiaque_enr, dm.seuil_max_medecin, dm.seuil_min_medecin "
                + "FROM enregistrements enr  INNER JOIN dossiermedical dm ON enr.id_personne = dm.id_personne  "
                + "WHERE enr.id_personne = ?";
        
        // Liste qui va contenir les enregistrements
        List<EnrEntity> enr = new LinkedList<>();
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {
            
            // Insère les données à modifier de la personne dans la requête
            ps.setInt(1, id_personne);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                enr.add(new EnrEntity(rs.getFloat(2), rs.getString(1), rs.getFloat(3), rs.getFloat(4)));
            }
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enr;
    }
    
    /**
     * Modifie les données d'un 
     * @param id Numéro de la personne
     * @param fume Boolean pour fumeur ou non
     * @param hta Boolean pour hta ou non
     * @param diabete Boolean pour diabétique ou non
     * @param smin Float Seuil Minimum du médecin
     * @param smax Float Seuil Maximum du médecin
     */
    public void modifDossier(int id, String fume, String hta, String diabete, float smin, float smax) {
        String rq = "UPDATE dossiermedical SET seuil_min_medecin = ?, "
                + "seuil_max_medecin = ?, fumeur = ?, hypertension = ?, diabete = ?"
                + "WHERE id_personne = ?";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)){
            
            ps.setFloat(1, smin);
            ps.setFloat(2, smax);
            ps.setString(3, fume);
            ps.setString(4, hta);
            ps.setString(5, diabete);
            ps.setInt(6, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
