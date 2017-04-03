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
    private boolean smoke;
    private boolean hta;
    private boolean diabete;
    private int idPerson;
    
    public MedFolderEntity(int idFolder, float tMax, float tMin, boolean smoke,
            boolean hta, boolean diabete, int idPerson){
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

    public boolean isSmoke() {
        return smoke;
    }

    public boolean isHta() {
        return hta;
    }

    public boolean isDiabete() {
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

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public void setHta(boolean hta) {
        this.hta = hta;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    
    
    
}
