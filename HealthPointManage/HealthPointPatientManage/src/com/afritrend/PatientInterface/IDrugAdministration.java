/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.DrugAdministrationBean;
import com.afritrend.PatientModel.DrugAdministrationModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IDrugAdministration {
    String SaveDrugAdministration(DrugAdministrationModel drugadministration);
    String UpdateDrugAdministration (DrugAdministrationModel drugadministration);   
    String ReverseDrugAdministration(DrugAdministrationModel drugadministration);   
    List<DrugAdministrationModel> ViewDrugAdministration();    
    List<DrugAdministrationModel> SearchDrugAdministration(String PatientName, String DrugAdmissionDate, String DrugClass);    
    List<DrugAdministrationBean> FilterDrugAdministration(String PatientID, String DrugType, String DrugName, String StartDate, String StopDate);    
}
