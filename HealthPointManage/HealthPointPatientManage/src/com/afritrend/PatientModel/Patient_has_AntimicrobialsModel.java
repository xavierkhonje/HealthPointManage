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
public class Patient_has_AntimicrobialsModel implements Serializable, Cloneable{
    private String patientid;
    private String antimicrobial;

    public Patient_has_AntimicrobialsModel() {
    }

    public Patient_has_AntimicrobialsModel(String patientid, String antimicrobial) {
        this.patientid = patientid;
        this.antimicrobial = antimicrobial;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getAntimicrobial() {
        return antimicrobial;
    }

    public void setAntimicrobial(String antimicrobial) {
        this.antimicrobial = antimicrobial;
    }

    @Override
    public String toString() {
        return "Patient_has_AntimicrobialsModel{" + "patientid=" + patientid + ", antimicrobial=" + antimicrobial + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
