/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IDemographics;
import com.afritrend.PatientModel.demographicsModel;
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
public class DemographicsDataAccess implements IDemographics{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String Savedemographics(demographicsModel demographics, String PatientID) {
        try
        {
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveDemographics(?,?,?,?,?,?,?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, demographics.getDateofbirth());
            stmt.setInt(2, demographics.getAge());
            stmt.setString(3, demographics.getDateOfAdmission());
            stmt.setInt(4, demographics.getWeight());
            stmt.setString(5, demographics.getGender());
            stmt.setString(6, demographics.getCultureAssessment());
            stmt.setString(7, demographics.getCultureResults());
            stmt.setString(8, PatientID);
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
    public String Updatedemographics(demographicsModel demographics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<demographicsModel> Viewdemographics() {
        List<demographicsModel> demographicslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETAllergies}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                demographicsModel demographics = new demographicsModel();
                
                demographics.setDateofbirth(rs.getString("dob"));
                demographics.setAge(rs.getInt("age"));
                demographics.setDateOfAdmission(rs.getString("dateofadmission"));
                demographics.setWeight(rs.getInt("weight"));
                demographics.setGender(rs.getString("gender"));
                demographics.setCultureAssessment(rs.getString("cultureAssessment"));
                demographics.setCultureResults(rs.getString("cultureResults"));
                
                demographicslist.add(demographics);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return demographicslist;        
    }

    @Override
    public String Deactivateudemographics(demographicsModel demographics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer SearchdemographicsID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public demographicsModel SearchPatientdemographics(String PatientID) {   
        
        demographicsModel demographics = new demographicsModel();
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETPatientDemographics(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                
                demographics.setDateofbirth(rs.getString("dob"));
                demographics.setAge(rs.getInt("age"));
                demographics.setDateOfAdmission(rs.getString("dateofadmission"));
                demographics.setWeight(rs.getInt("weight"));
                demographics.setGender(rs.getString("gender"));
                demographics.setCultureAssessment(rs.getString("cultureAssessment"));
                demographics.setCultureResults(rs.getString("cultureResults"));
                
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return demographics;          
    }
    
}
