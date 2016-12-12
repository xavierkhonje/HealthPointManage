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
public class DrugAdministrationBean implements Serializable, Cloneable{
    private String patientID;
    private String patientName;
    private String administrationid;
    private String isdrugadministered;
    private String FK_iddrugprescription;
    private String iddrugadministration;
    private String administrationdate;
    private String administrationtime;
    private String DrugName;
    private String Cmscode;

    public DrugAdministrationBean() {
    }

    public DrugAdministrationBean(String patientID, String patientName, String administrationid, String isdrugadministered, String FK_iddrugprescription, String iddrugadministration, String administrationdate, String administrationtime, String DrugName, String Cmscode) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.administrationid = administrationid;
        this.isdrugadministered = isdrugadministered;
        this.FK_iddrugprescription = FK_iddrugprescription;
        this.iddrugadministration = iddrugadministration;
        this.administrationdate = administrationdate;
        this.administrationtime = administrationtime;
        this.DrugName = DrugName;
        this.Cmscode = Cmscode;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAdministrationid() {
        return administrationid;
    }

    public void setAdministrationid(String administrationid) {
        this.administrationid = administrationid;
    }

    public String getIsdrugadministered() {
        return isdrugadministered;
    }

    public void setIsdrugadministered(String isdrugadministered) {
        this.isdrugadministered = isdrugadministered;
    }

    public String getFK_iddrugprescription() {
        return FK_iddrugprescription;
    }

    public void setFK_iddrugprescription(String FK_iddrugprescription) {
        this.FK_iddrugprescription = FK_iddrugprescription;
    }

    public String getIddrugadministration() {
        return iddrugadministration;
    }

    public void setIddrugadministration(String iddrugadministration) {
        this.iddrugadministration = iddrugadministration;
    }

    public String getAdministrationdate() {
        return administrationdate;
    }

    public void setAdministrationdate(String administrationdate) {
        this.administrationdate = administrationdate;
    }

    public String getAdministrationtime() {
        return administrationtime;
    }

    public void setAdministrationtime(String administrationtime) {
        this.administrationtime = administrationtime;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
    }

    public String getCmscode() {
        return Cmscode;
    }

    public void setCmscode(String Cmscode) {
        this.Cmscode = Cmscode;
    }

    @Override
    public String toString() {
        return "DrugAdministration{" + "patientID=" + patientID + ", patientName=" + patientName + ", administrationid=" + administrationid + ", isdrugadministered=" + isdrugadministered + ", FK_iddrugprescription=" + FK_iddrugprescription + ", iddrugadministration=" + iddrugadministration + ", administrationdate=" + administrationdate + ", administrationtime=" + administrationtime + ", DrugName=" + DrugName + ", Cmscode=" + Cmscode + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
