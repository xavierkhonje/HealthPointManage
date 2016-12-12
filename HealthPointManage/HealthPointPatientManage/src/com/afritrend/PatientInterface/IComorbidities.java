/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.CormobiditiesModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IComorbidities {
    String SaveCormobidities(CormobiditiesModel cormobidities);
    String UpdateCormobidities(CormobiditiesModel cormobidities);   
    List<CormobiditiesModel> ViewCormobidities();     
    List<CormobiditiesModel> ViewPatientCormobidities(String PatientID);     
}
