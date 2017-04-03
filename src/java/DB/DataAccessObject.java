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

        String rq;

        rq = "insert into personne(nom_personne, prenom_personne, "
                + "date_naissance, taille_personne, poids_personne, "
                + "sexe_personne, login_personne, mdp_personne)"
                + "values(?,?,?,?,?,?,?,?)";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {
            this.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(rq);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<MedFolderEntity> getDossierMedical(int id_personne) {
        //List<MedFolderEntity> rs = new LinkedList<>();

        String rq;

        rq = "Select * "
                + "From dossiermedical "
                + "Where dossiermedical.id_personne = ? ";

        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {

            try (ResultSet rs = rq.executeQuery()) {
                int idFolder = rs.getIdFolder();
                int tMax = rs.gettMax();
                int tMin = rs.gettMin();
                boolean smoke = rs.getSmoke();
                boolean hta = rs.getHta();
                boolean diabete = rs.getDiabete();
                int idPerson = rs.getIdPerson();
            }

            MedFolderEntity c = new MedFolderEntity(id, name, address);
            // On l'ajoute à la liste des résultats
            rs.add(c);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;
    }
}
