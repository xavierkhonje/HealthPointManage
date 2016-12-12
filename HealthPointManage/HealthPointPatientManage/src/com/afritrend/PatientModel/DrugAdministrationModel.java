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
public class DrugAdministrationModel implements Serializable{
    
    private int iddrugadministration;
    private int administrationid;
    private String administrationdate;
    private String administrationtime;
    private int isdrugadministered;
    private int fk_iddrugprescription;

    private String Message = "";
    
    public String getMessage()
    {
        return this.Message;
    }      
    
    public DrugAdministrationModel(){
    }

    public DrugAdministrationModel(int iddrugadministration, int administrationid, String administrationdate, String administrationtime, int isdrugadministered, int fk_iddrugprescription) {
        this.iddrugadministration = iddrugadministration;
        this.administrationid = administrationid;
        this.administrationdate = administrationdate;
        this.administrationtime = administrationtime;
        this.isdrugadministered = isdrugadministered;
        this.fk_iddrugprescription = fk_iddrugprescription;
    }

    public int getIddrugadministration() {
        return iddrugadministration;
    }

    public void setIddrugadministration(int iddrugadministration) {
        this.iddrugadministration = iddrugadministration;
    }

    public int getAdministrationid() {
        return administrationid;
    }

    public void setAdministrationid(int administrationid) {
        this.administrationid = administrationid;
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

    public int getIsdrugadministered() {
        return isdrugadministered;
    }

    public void setIsdrugadministered(int isdrugadministered) {
        this.isdrugadministered = isdrugadministered;
    }

    public int getFk_iddrugprescription() {
        return fk_iddrugprescription;
    }

    public void setFk_iddrugprescription(int fk_iddrugprescription) {
        this.fk_iddrugprescription = fk_iddrugprescription;
    }

    @Override
    public String toString() {
        return "DrugAdministrationModel{" + "iddrugadministration=" + iddrugadministration + ", administrationid=" + administrationid + ", administrationdate=" + administrationdate + ", administrationtime=" + administrationtime + ", isdrugadministered=" + isdrugadministered + ", fk_iddrugprescription=" + fk_iddrugprescription + ", Message=" + Message + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //validation starts here
    public boolean validate()
    {
        if(this.getAdministrationid() == 0)
        {
            this.Message = "Please Enter a Administration ID";
            return false;
        }
        
        if(this.getAdministrationdate().equals(""))
        {
            this.Message = "Please Provide Administration Date";
            return false;
        }
        
        if(this.getAdministrationtime().equals(""))
        {
            this.Message = "Please Provide Administration Time";
            return false;
        }        
        
        if(this.getFk_iddrugprescription() == 0)
        {
            this.Message = "Please Provide Drug Prescribed";
            return false;
        }   
        
        if(this.getIsdrugadministered() == 0)
        {
            this.Message = "Please Supply Drug Admission value";
            return false;
        }        
        
        return true;
    }    
    
}
