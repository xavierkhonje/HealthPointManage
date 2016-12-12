/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.sourceModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface ISource {
    String SaveSource(sourceModel source);
    String UpdateSource(sourceModel source);   
    List<sourceModel> ViewSource();      
    List<sourceModel> ViewSourceByID(String PatientID);      
}
