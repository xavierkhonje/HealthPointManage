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
public class demographicsModel implements Serializable, Cloneable{
    private String dateofbirth;
    private int age;
    private String dateOfAdmission;
    private int weight;
    private String gender;
    private String cultureAssessment;
    private String cultureResults;

    public demographicsModel() {
    }

    public demographicsModel(String dateofbirth, int age, String dateOfAdmission, int weight, String gender, String cultureAssessment, String cultureResults) {
        this.dateofbirth = dateofbirth;
        this.age = age;
        this.dateOfAdmission = dateOfAdmission;
        this.weight = weight;
        this.gender = gender;
        this.cultureAssessment = cultureAssessment;
        this.cultureResults = cultureResults;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCultureAssessment() {
        return cultureAssessment;
    }

    public void setCultureAssessment(String cultureAssessment) {
        this.cultureAssessment = cultureAssessment;
    }

    public String getCultureResults() {
        return cultureResults;
    }

    public void setCultureResults(String cultureResults) {
        this.cultureResults = cultureResults;
    }

    @Override
    public String toString() {
        return "demographicsModel{" + "dateofbirth=" + dateofbirth + ", age=" + age + ", dateOfAdmission=" + dateOfAdmission + ", weight=" + weight + ", gender=" + gender + ", cultureAssessment=" + cultureAssessment + ", cultureResults=" + cultureResults + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
