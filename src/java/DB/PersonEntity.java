/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author sacha
 */
public class PersonEntity {
 
    private int id;
    private String nom;
    private String prenom;
    private String date;
    private float taille;
    private float poids;
    private String login;
    private String password;
    
    /**
     * Constructeur complet de personnes
     * @param id Identifiant de la personne
     * @param prenom Prenom
     * @param nom Nom
     * @param date Date de naissance
     * @param taille Taille
     * @param poids Poids
     * @param login Identifiant web
     * @param pwd Mot de passe
     */
    public PersonEntity(int id, String prenom, String nom, String date,
            float taille, float poids, String login, String pwd) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.taille = taille;
        this.poids = poids;
        this.login = login;
        this.password = pwd;
    }

    /**
     * Constructeur alternatif de personnes contenant le nom et l'identifiant
     * @param id Identifiant de la personne
     * @param nom Nom de la personne
     */
    public PersonEntity(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    // Getters
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate() {
        return date;
    }

    public float getTaille() {
        return taille;
    }

    public float getPoids() {
        return poids;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    
    // Setters
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
