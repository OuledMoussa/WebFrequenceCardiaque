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
public class EnrEntity {
    private int idEnr;
    private float freq;
    private String dateEnr;
    private int idPerson;
    
    public EnrEntity(int idEnr, float freq, String date, int idPerson) {
        this.idEnr = idEnr;
        this.freq = freq;
        this.dateEnr = date;
        this.idPerson = idPerson;
    }

    public int getIdEnr() {
        return idEnr;
    }

    public float getFreq() {
        return freq;
    }

    public String getDateEnr() {
        return dateEnr;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdEnr(int idEnr) {
        this.idEnr = idEnr;
    }

    public void setFreq(float freq) {
        this.freq = freq;
    }

    public void setDateEnr(String dateEnr) {
        this.dateEnr = dateEnr;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    
    
    }
