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
public class HomeMedicationModel implements Serializable{
    
    private String drugName;
    private String indication;
    private String startdate;
    private String duration;
    private String planonsubmission;
    private String chartered;
    private String dose;
    private String route;
    private int frequency;
    private String patientID;
    private String Message = "";
    
    public HomeMedicationModel() {
    }

    public HomeMedicationModel(String drugName, String indication, String startdate, String duration, String planonsubmission, String chartered, String dose, String route, int frequency, String patientID) {
        this.drugName = drugName;
        this.indication = indication;
        this.startdate = startdate;
        this.duration = duration;
        this.planonsubmission = planonsubmission;
        this.chartered = chartered;
        this.dose = dose;
        this.route = route;
        this.frequency = frequency;
        this.patientID = patientID;
    }


    
    public String getMessage()
    {
        return this.Message;
    }      

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlanonsubmission() {
        return planonsubmission;
    }

    public void setPlanonsubmission(String planonsubmission) {
        this.planonsubmission = planonsubmission;
    }

    public String getChartered() {
        return chartered;
    }

    public void setChartered(String chartered) {
        this.chartered = chartered;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "HomeMedicationModel{" + "drugName=" + drugName + ", indication=" + indication + ", startdate=" + startdate + ", duration=" + duration + ", planonsubmission=" + planonsubmission + ", chartered=" + chartered + ", dose=" + dose + ", route=" + route + ", frequency=" + frequency + ", patientID=" + patientID + ", Message=" + Message + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //validation starts here
    public boolean validate()
    {
        if(this.getDrugName().equals(""))
        {
            this.Message = "Please Enter a Drug";
            return false;
        }
        
        if(this.startdate.equals(""))
        {
            this.Message = "Please Supply a Start Date";
            return false;
        }
        
        return true;
    }       
    
}
