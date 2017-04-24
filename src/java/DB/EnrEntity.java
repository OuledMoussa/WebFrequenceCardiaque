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
    private float freq;
    private String dateEnr;
    private float fmax;
    private float fmin;
    
    public EnrEntity(float freq, String date, float fmax, float fmin) {
        this.freq = freq;
        this.dateEnr = date;
        this.fmin = fmax;
        this.fmax = fmin;
    }
    
    // Ensemble des getters
    
    public float getFreq() {
        return freq;
    }

    public String getDateEnr() {
        return dateEnr;
    }

    public float getFmax() {
        return fmax;
    }

    public float getFmin() {
        return fmin;
    }

    // Ensemble des setters
    
    public void setFreq(float freq) {
        this.freq = freq;
    }

    public void setDateEnr(String dateEnr) {
        this.dateEnr = dateEnr;
    }

    public void setFmax(float fmax) {
        this.fmax = fmax;
    }

    public void setFmin(float fmin) {
        this.fmin = fmin;
    }
        
    
    }
