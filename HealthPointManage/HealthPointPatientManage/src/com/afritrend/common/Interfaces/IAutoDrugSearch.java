/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Interfaces;

import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IAutoDrugSearch {
    List<String> GetDrugClass();
    List<String> GetDosageForms();    
    List<String> GetDrugNamesByDosageForm(String DosageForm);
    List<String> GetStrengthByDrugNames(String DrugName);
}
