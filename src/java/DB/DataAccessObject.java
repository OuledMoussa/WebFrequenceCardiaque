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
     * @param utilisateur
     * @param mdp
     */
    public PersonEntity utilisateurConnect(String utilisateur,
            String mdp) {
        // Personne qui se connecte
        PersonEntity personne = null;
        // Requête à exécuter
        String rq = "SELECT id_personne, nom_personne, prenom_personne, "
                + "login_personne, mdp_personne, img_personne "
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
                personne = new PersonEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6));                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personne;
    }
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param ddn
     * @param taille
     * @param poids
     * @param sexe
     * @param login
     * @param mdp 
     */
    public void nouveauUtilisateur(String nom, String prenom, String ddn, float taille, float poids, String sexe, String login, String mdp, String mail) {

        String query;

        query = "insert into personne(nom_personne, prenom_personne, "
                + "date_naissance, taille_personne, poids_personne, "
                + "sexe_personne, login_personne, mdp_personne, mail_personne, img_personne)"
                + "values(?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,'./img/pers/new.jpg')";

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
            ps.setString(9, mail);
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
                
                if (rs.next()) {
                
                idFolder = rs.getInt(1);
                tMax = rs.getFloat(2);
                tMin = rs.getFloat(3);
                smoke = rs.getString(4);
                hta = rs.getString(5);
                diabete = rs.getString(6);
                idPerson = rs.getInt(7);

                
                result = new MedFolderEntity(idFolder, tMax, tMin, smoke,
                        hta, diabete, idPerson);
                } else {
                    result = null;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * Donne tous les enregistrements de fréquence cardiaque pour une personne
     * @param id_personne Identifiant de la personne dans la bd (int
     * @return List<EnrEntity> Liste de tous les enregistrements
     */
    public List<EnrEntity> frequenceFQ(int id_personne) throws SQLException {
        // Requête qui récupère uniquement la date, la fréquence et les seuils du médecin        
        String rq = "SELECT enr.date_enregistrement, enr.frequence_cardiaque_enr, dm.seuil_max_medecin, dm.seuil_min_medecin "
                + "FROM enregistrements enr  INNER JOIN dossiermedical dm ON enr.id_personne = dm.id_personne  "
                + "WHERE enr.id_personne = ? order by date_enregistrement asc";
        
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
     * Donne tous les enregistrements de fréquence cardiaque pour une personne
     * @param debut de la période des enregistrements
     * @param fin de la période des enregistrements
     * @param id_personne Identifiant de la personne dans la bd (int)
     * @return List<EnrEntity> Liste de tous les enregistrements
     */
    public List<EnrEntity> frequenceFQPeriode(String debut, String fin, int id_personne) throws SQLException {
        // Requête qui récupère uniquement la date, la fréquence et les seuils du médecin        
        String rq = "SELECT enr.date_enregistrement, enr.frequence_cardiaque_enr, dm.seuil_max_medecin, dm.seuil_min_medecin "
                + "FROM enregistrements enr  INNER JOIN dossiermedical dm ON enr.id_personne = dm.id_personne  "
                + "WHERE enr.id_personne = ? and date_enregistrement between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')"
                + "order by date_enregistrement asc";
        
        // Liste qui va contenir les enregistrements
        List<EnrEntity> enr = new LinkedList<>();
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)) {
            
            // Insère les données à modifier de la personne dans la requête
            ps.setInt(1, id_personne);
            ps.setString(2, debut);
            ps.setString(3, fin);
            
            
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
    
    
    /**
     * Ajoute les données médicale d'une personne
     * @param id Numéro de la personne
     * @param fume Boolean pour fumeur ou non
     * @param hta Boolean pour hta ou non
     * @param diabete Boolean pour diabétique ou non
     * @param smin Float Seuil Minimum du médecin
     * @param smax Float Seuil Maximum du médecin
     */
    public void AjoutDossier(int id, String fume, String hta, String diabete, float smin, float smax) {
        String rq = "INSERT INTO dossiermedical(seuil_min_medecin, "
                + "seuil_max_medecin, fumeur, hypertension, diabete, "
                + "id_personne) values(?,?,?,?,?,?)";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)){
            
            ps.setFloat(1, smin);
            ps.setFloat(2, smax);
            ps.setString(3, fume);
            ps.setString(4, hta);
            ps.setString(5, diabete);
            ps.setInt(6, id);
            
            ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Donne les informations de la base de données sur un utilisateur
     * @param id_personne Identifiant de la personne dans la base de données (int)
     * @return Information sur la personne (PersonEntity)
     */
    public PersonEntity infoPersonne(int id_personne) {
        // Initialisation de l'objet Personne qui va recevoir les données
        PersonEntity info = null;
        
        // Requête qui va être exécutée
        String rq = "SELECT date_naissance, taille_personne, poids_personne,"
                + "sexe_personne, mail_personne, login_personne "
                + "FROM personne WHERE id_personne = ?";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)){
            
           // Ajoute l'identifiant de l'utilisateur à la requête
           ps.setInt(1, id_personne);
            
           // Exécute la requête
           ResultSet rs = ps.executeQuery();
           
           // Récupère les données
           rs.next();
           info = new PersonEntity(rs.getString(1), rs.getFloat(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return info;
        
    }
    
    /**
     * Effectue les requêtes concernant les paramètres qui ont étés modifiés
     * @param modifs Tableau qui comprend le nom du paramètre, et le résultat
     * @param id L'identifiant de l'utilisateur
     */
    public void modifCompte(String[][] modifs, int id) throws SQLException {
    	/* Test pour éviter les erreurs si un paramètre n'existe pas
         * il n'y a pas d'erreur d'exécution de fausse requête
         */
        boolean test = true;

        // Vise la première colonne pour les nom de paramètres
        int col = 0;
        // Initialisation de la requête
        String rq = "";
    	for (int lg = 0; lg < modifs[0].length; lg++) {
            // Obtient la connexion à la base de données
            Connection connect = myDataSource.getConnection();
            // Prépare la requete
            PreparedStatement ps = null;
            switch(modifs[col][lg]) {
            case "sexe":
                    rq = "UPDATE personne set sexe_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setString(1,modifs[col+1][lg]);
                    ps.setInt(2,id);
                    break;
            case "ddn":
                    rq = "UPDATE personne set date_naissance = to_date(?,'DD/MM/YYYY') WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setString(1,modifs[col+1][lg]);
                    ps.setInt(2,id);
                    break;
            case "poids":
                    rq = "UPDATE personne set poids_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setFloat(1,Float.parseFloat(modifs[col+1][lg]));
                    ps.setInt(2,id);
                    break;
            case "taille":
                    rq = "UPDATE personne set taille_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setFloat(1,Float.parseFloat(modifs[col+1][lg]));
                    ps.setInt(2,id);
                    break;
            case "mail":
                    rq = "UPDATE personne set mail_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setString(1,modifs[col+1][lg]);
                    ps.setInt(2,id);
                    break;
            case "login":
                    rq = "UPDATE personne set login_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setString(1,modifs[col+1][lg]);
                    ps.setInt(2,id);
                    break;
            case "mdp":
                    rq = "UPDATE personne set mdp_personne = ? WHERE id_personne = ?";
                    ps = connect.prepareStatement(rq);
                    ps.setString(1,modifs[col+1][lg]);
                    ps.setInt(2,id);
                    break;
            default:
                test = false;
            }  		
            
            if (test) {
                ps.executeUpdate();
            }
            
    		
    	}
    }
        
    /**
     * Change l'avatar de la personne
     * @param image nom de l'avatar de la personne
     * @param id L'identifiant de l'utilisateur
     * @throws 
     */
    public void modifImage(String image, int id) throws SQLException {
    	// Requête de modification de la base de données
        String rq = "UPDATE personne set img_personne = ? WHERE id_personne = ?";
        
        // Obtient la connexion à la base de données
        Connection connect = myDataSource.getConnection();
        // Prépare la requete
        PreparedStatement ps = connect.prepareStatement(rq);

        ps.setString(1,"./img/pers/" + image);
        ps.setInt(2,id);
        
        // Met à jour la base de données
        ps.executeUpdate();
        
    }
    
    
    
    /**
     * Renvoi les informations statistiques de base
     * @param id_personne Identifiant de la personne dans la base de données (int)
     * @return tableau des resultats
     */
    public String[] stats(int id_personne) {
        // Initialisation de l'objet Personne qui va recevoir les données
        String stat[] = {"","",""};
        
        // Requête qui va être exécutée
        String rq = "SELECT round(max(frequence_cardiaque_enr),0), round(avg(frequence_cardiaque_enr),0), round(min(frequence_cardiaque_enr),0)"
                + "FROM enregistrements WHERE id_personne = ?";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)){
            
           // Ajoute l'identifiant de l'utilisateur à la requête
           ps.setInt(1, id_personne);
            
           // Exécute la requête
           ResultSet rs = ps.executeQuery();
           
           // Récupère les données
           rs.next();
           stat[0] =  String.valueOf(rs.getFloat(1));
           stat[1] = String.valueOf(rs.getFloat(2));
           stat[2] = String.valueOf(rs.getFloat(3));
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stat;
        
    }
    
    
    /**
     * Renvoi les informations statistiques de base pour une période donnée
     * @param id_personne Identifiant de la personne dans la base de données (int)
     * @return tableau des resultats
     */
    public String[] statsPeriode(int id_personne, String debut, String fin) {
        // Initialisation de l'objet Personne qui va recevoir les données
        String stat[] = {"","",""};
        
        // Requête qui va être exécutée
        String rq = "SELECT round(max(frequence_cardiaque_enr),0), round(avg(frequence_cardiaque_enr),0), round(min(frequence_cardiaque_enr),0)"
                + "FROM enregistrements "
                + "WHERE id_personne = ?"
                + "and date_enregistrement between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')";
        
        try (Connection connect = myDataSource.getConnection();
                PreparedStatement ps = connect.prepareStatement(rq)){
            
           // Ajoute l'identifiant de l'utilisateur à la requête
           ps.setInt(1, id_personne);
           // Met les dates
           ps.setString(2, debut);
           ps.setString(3, fin);
           
           // Exécute la requête
           ResultSet rs = ps.executeQuery();
           
           // Récupère les données
           rs.next();
           stat[0] =  String.valueOf(rs.getFloat(1));
           stat[1] = String.valueOf(rs.getFloat(2));
           stat[2] = String.valueOf(rs.getFloat(3));
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stat;
        
    }
        
}
