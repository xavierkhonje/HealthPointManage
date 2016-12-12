/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientModel;

import java.io.Serializable;

/**
 *
 * @author Xavier Khonje
 */
public class Patient_has_comorbiditiesModel implements Serializable, Cloneable{
    
    private String patientid;
    private String comorbidities;

    public Patient_has_comorbiditiesModel() {
    }

    public Patient_has_comorbiditiesModel(String patientid, String comorbidities) {
        this.patientid = patientid;
        this.comorbidities = comorbidities;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(String comorbidities) {
        this.comorbidities = comorbidities;
    }

    @Override
    public String toString() {
        return "Patient_has_comorbiditiesModel{" + "patientid=" + patientid + ", comorbidities=" + comorbidities + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
