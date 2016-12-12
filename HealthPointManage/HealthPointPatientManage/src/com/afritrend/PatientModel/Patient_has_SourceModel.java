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
public class Patient_has_SourceModel implements Serializable, Cloneable{
    
    private String patientid;
    private String sourceid;

    public Patient_has_SourceModel() {
    }

    public Patient_has_SourceModel(String patientid, String sourceid) {
        this.patientid = patientid;
        this.sourceid = sourceid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    @Override
    public String toString() {
        return "Patient_has_SourceModel{" + "patientid=" + patientid + ", sourceid=" + sourceid + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
