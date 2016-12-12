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
public class Patient_has_DiagnosisModel implements Serializable, Cloneable{
    
    private String patientid;
    private String diagnosis;

    public Patient_has_DiagnosisModel() {
    }

    public Patient_has_DiagnosisModel(String patientid, String diagnosis) {
        this.patientid = patientid;
        this.diagnosis = diagnosis;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient_has_DiagnosisModel{" + "patientid=" + patientid + ", diagnosis=" + diagnosis + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
