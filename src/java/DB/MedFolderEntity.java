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
public class MedFolderEntity {
    
    private int idFolder;
    private float tMax;
    private float tMin;
    private String smoke;
    private String hta;
    private String diabete;
    private int idPerson;
    
    public MedFolderEntity(int idFolder, float tMax, float tMin, String smoke,
            String hta, String diabete, int idPerson){
        this.idFolder = idFolder;
        this.tMax = tMax;
        this.tMin = tMin;
        this.smoke = smoke;
        this.hta = hta;
        this.diabete = diabete;
        this.idPerson = idPerson;
    }

    public int getIdFolder() {
        return idFolder;
    }

    public float gettMax() {
        return tMax;
    }

    public float gettMin() {
        return tMin;
    }

    public String isSmoke() {
        return smoke;
    }

    public String isHta() {
        return hta;
    }

    public String isDiabete() {
        return diabete;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdFolder(int idFolder) {
        this.idFolder = idFolder;
    }

    public void settMax(float tMax) {
        this.tMax = tMax;
    }

    public void settMin(float tMin) {
        this.tMin = tMin;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public void setHta(String hta) {
        this.hta = hta;
    }

    public void setDiabete(String diabete) {
        this.diabete = diabete;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    
    
    
}
