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
    private String sexe;
    private String mail;
    private String login;
    private String password;
    private String img;
    
    /**
     * Constructeur complet de personnes
     * @param id Identifiant de la personne
     * @param prenom Prenom
     * @param nom Nom
     * @param date Date de naissance
     * @param taille Taille
     * @param poids Poids
     * @param mail Adresse mail
     * @param login Identifiant web
     * @param pwd Mot de passe
     */
    public PersonEntity(int id, String prenom, String nom, String date,
            float taille, float poids, String mail, String login, String pwd) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.taille = taille;
        this.poids = poids;
        this.sexe = sexe;
        this.mail = mail;
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
    
    /**
     * Constructeur alternatif pour la récupération des données du compte de
     * l'utilisateur
     * @param ddn Date de naissance de la personne
     * @param taille Taille de la personne
     * @param poids Poids de la personne
     * @param mail Adresse mail de la personne
     * @param login Login de connexion de la personne
     */
    public PersonEntity(String ddn, float taille, float poids, String sexe, String mail, String login) {
        this.date = ddn;
        this.taille = taille;
        this.poids = poids;
        this.sexe = sexe;
        this.mail = mail;
        this.login = login;
    }
    
    public PersonEntity(int id, String nom, String prenom, String img) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.img = img;
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

    public String getMail() {
        return mail;
    }

    public String getSexe() {
        return sexe;
    }
    
    
    public String getImg() {
        return img;
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
    
    public void setImg(String img) {
        this.img = img;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    
}
