/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.AntimicrobialsModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IAntimicrobials {
    String SaveAntimicrobials(AntimicrobialsModel Antimicrobials);
    String UpdateAntimicrobials(AntimicrobialsModel Antimicrobials);   
    List<AntimicrobialsModel> ViewAntimicrobials();     
    List<AntimicrobialsModel> ViewPatientAntimicrobials(String PatientID);     
}
