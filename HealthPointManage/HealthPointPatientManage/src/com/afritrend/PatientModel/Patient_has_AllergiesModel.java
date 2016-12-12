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
public class Patient_has_AllergiesModel implements Serializable,Cloneable{
    private String patientid;
    private String allergies;

    public Patient_has_AllergiesModel() {
    }

    public Patient_has_AllergiesModel(String patientid, String allergies) {
        this.patientid = patientid;
        this.allergies = allergies;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Patient_has_AllergiesModel{" + "patientid=" + patientid + ", allergies=" + allergies + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
