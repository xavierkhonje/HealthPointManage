/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IHomeMedication;
import com.afritrend.PatientModel.HomeMedicationModel;
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
public class HomeMedicationDataAccess implements IHomeMedication{
    
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     

    @Override
    public String SaveHomeMedication(HomeMedicationModel homemedication) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveHomeMedication(?,?,?,?,?,?,?,?,?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, homemedication.getIndication());
                stmt.setString(2, homemedication.getStartdate());
                stmt.setString(3, homemedication.getDuration());
                stmt.setString(4, homemedication.getDrugName());
                stmt.setString(5, homemedication.getPatientID());       
                stmt.setString(6, homemedication.getPlanonsubmission());                
                stmt.setString(7, homemedication.getChartered());
                stmt.setInt(8, homemedication.getFrequency());
                stmt.setString(9, homemedication.getDose());
                stmt.setString(10, homemedication.getRoute());
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
    public String UpdateHomeMedication(HomeMedicationModel homemedication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ReverseHomeMedication(HomeMedicationModel homemedication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HomeMedicationModel> ViewHomeMedication() {
        List<HomeMedicationModel> homemedlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETHomeMedication}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                HomeMedicationModel homemed = new HomeMedicationModel();
                homemed.setDrugName(rs.getString("patientID"));
                homemed.setIndication(rs.getString("patientName"));
                homemedlist.add(homemed);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return homemedlist;        
    }

    @Override
    public List<HomeMedicationModel> SearchHomeMedication(String PatientName, String DrugAdmissionDate, String DrugClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HomeMedicationModel> ViewPatientHomeMedication(String PatientID) {
        List<HomeMedicationModel> homemedlist =  null;
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETHomeMedication(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            homemedlist = new ArrayList();
            while(rs.next())
            {
                HomeMedicationModel homemed = new HomeMedicationModel();
                
                homemed.setIndication(rs.getString("indication"));
                homemed.setStartdate(rs.getString("StartDate"));
                homemed.setDuration(rs.getString("Duration"));
                homemed.setPlanonsubmission(rs.getString("PlanOnSubmission"));
                homemed.setChartered(rs.getString("Chartered"));
                homemed.setFrequency(rs.getInt("Frequency"));
                homemed.setDose(rs.getString("Dose"));
                homemed.setRoute(rs.getString("Route"));
                homemed.setDrugName(rs.getString("DrugName"));
                
                homemedlist.add(homemed);
            }                        
        }
        catch(Exception e)
        {
            e.getMessage();
        }        
        finally
        {
            
        }        
        
        return homemedlist;         
    }
    
}
