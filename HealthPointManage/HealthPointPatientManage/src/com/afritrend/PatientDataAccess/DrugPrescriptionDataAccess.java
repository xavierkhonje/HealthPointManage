/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IDrugPrescription;
import com.afritrend.PatientModel.AntibioticPrescriptionModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class DrugPrescriptionDataAccess implements IDrugPrescription{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;       
    
    @Override
    public String SaveDrugPrescription(AntibioticPrescriptionModel drugprescription, String PatientID, String DrugType) {
            try
            {
                //send a full table
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveDrugPrescription(?,?,?,?,?,?)}";    
                
                stmt = conn.prepareCall(sql);
                stmt.setString(1, PatientID);
                stmt.setString(2, drugprescription.getfK_cmscode());
                stmt.setString(3, drugprescription.getStartdate());
                stmt.setString(4, drugprescription.getEnddate());
                stmt.setInt(5, drugprescription.getFrequency());
                stmt.setString(6, DrugType);
                
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Store Procedure Processed";
            }         
    }

    @Override
    public String UpdateDrugPrescription(AntibioticPrescriptionModel drugadministration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ReverseDrugPrescription(AntibioticPrescriptionModel drugadministration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AntibioticPrescriptionModel> ViewDrugPrescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AntibioticPrescriptionModel> SearchDrugPrescription(String PatientName, String DrugAdmissionDate, String DrugClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AntibioticPrescriptionModel> ViewPatientDrugPrescription(String PatientID) {
        List<AntibioticPrescriptionModel> antibioticlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETPatientAntibiotics(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                AntibioticPrescriptionModel antibiotic = new AntibioticPrescriptionModel();
                antibiotic.setStartdate(rs.getString("startdate"));
                antibiotic.setEnddate(rs.getString("enddate"));
                antibiotic.setFrequency(rs.getInt("frequency"));
                antibiotic.setfK_cmscode(rs.getString("DrugName"));
                
                antibioticlist.add(antibiotic);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return antibioticlist;          
    }
    
}
