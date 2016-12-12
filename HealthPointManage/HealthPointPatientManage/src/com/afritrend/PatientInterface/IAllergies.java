/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.AllergiesModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IAllergies {
    String SaveAllergy(AllergiesModel Allergy);
    String UpdateAllergy(AllergiesModel Allergy);   
    List<AllergiesModel> ViewAllergy();     
    List<AllergiesModel> ViewPatientAllergies(String PatientID);     
}
