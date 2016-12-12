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
public class DiagnosisModel implements Serializable,Cloneable{
    
    private String code;
    private String description;

    public DiagnosisModel() {
    }

    public DiagnosisModel(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DiagnosisModel{" + "code=" + code + ", description=" + description + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
