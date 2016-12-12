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
public class AntibioticPrescriptionModel implements Serializable{
    
    private String startdate;
    private String enddate;
    private int frequency;
    private String fK_cmscode;

    
    private String Message = "";
    
    public String getMessage()
    {
        return this.Message;
    }     
    
    public AntibioticPrescriptionModel() {
    }

    public AntibioticPrescriptionModel(String startdate, String enddate, int frequency, String fK_cmscode) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.frequency = frequency;
        this.fK_cmscode = fK_cmscode;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getfK_cmscode() {
        return fK_cmscode;
    }

    public void setfK_cmscode(String fK_cmscode) {
        this.fK_cmscode = fK_cmscode;
    }
    
    public boolean validate()
    {
        if(this.getStartdate().equals(""))
        {
            this.Message = "Please Enter a Start Date";
            return false;
        }
        
        if(this.getEnddate().equals(""))
        {
            this.Message = "Please Provide Stop Date";
            return false;
        }
        
        if(this.getFrequency() == 0)
        {
            this.Message = "Please Provide Frequency";
            return false;
        }        
        
        if(this.getfK_cmscode().equals(""))
        {
            this.Message = "Please Provide Drug";
            return false;
        }               
        
        return true;
    }        
    
}
