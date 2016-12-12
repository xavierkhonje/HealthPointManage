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
public class Patient_Model implements Serializable{
    private String patientID;
    private String patientName;
    
    private String Message = "";
    
    public String getMessage()
    {
        return this.Message;
    }    

    public Patient_Model() {
    }

    public Patient_Model(String patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "PatientModel{" + "patientID=" + patientID + ", patientName=" + patientName + '}';
    }
    
    
    //validation starts here
    public boolean validate()
    {
        if(this.getPatientID().equals(""))
        {
            this.Message = "Please Enter a Patient ID";
            return false;
        }
        
        if(this.getPatientName().equals(""))
        {
            this.Message = "Please Supply a Patient Name";
            return false;
        }
        
        return true;
    }    
    
    
}
