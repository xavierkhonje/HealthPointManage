/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IPatient;
import com.afritrend.PatientModel.Patient_Model;
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
public class Patient_DataAccess implements IPatient{
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;   

    @Override
    public String SavePatient(Patient_Model patient, String Hosp, String Ward, String Warddpt) 
        {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SavePatientDetails(?,?,?,?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, patient.getPatientID());
                stmt.setString(2, patient.getPatientName());
                stmt.setString(3, Hosp);
                stmt.setString(4, Ward);
                stmt.setString(5, Warddpt);
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
    public String UpdatePatient(Patient_Model Patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient_Model> ViewPatient() {        
        List<Patient_Model> patientlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETPatientDetails}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                Patient_Model patient = new Patient_Model();
                patient.setPatientID(rs.getString("patientID"));
                patient.setPatientName(rs.getString("patientName"));
                patientlist.add(patient);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return patientlist;
    }
    @Override
    public String DeactivateuPatient(Patient_Model Patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer SearchPatientID(String criteria) {
        int PatientID = 0;
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETPatientByID(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, criteria);
            stmt.execute();            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                PatientID = rs.getInt("idpatient");
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return PatientID;        
    }

    @Override
    public List<Patient_Model> SearchPatient(String firstname, String middlename, String lastname, String patientid) {
        List<Patient_Model> patientlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_SearchPatient(?,?,?,?)}";   
            
            stmt = conn.prepareCall(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, middlename);            
            stmt.setString(3, lastname);            
            stmt.setString(4, patientid); 
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                Patient_Model patient = new Patient_Model();
                patient.setPatientID(rs.getString("patientID"));
                patient.setPatientName(rs.getString("patientName"));
                patientlist.add(patient);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return patientlist;        
    }

    @Override
    public Patient_Model SearchPatient(String PatientID) {
        
        Patient_Model patient = new Patient_Model();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETFULLPatientDetails(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();            
            rs = stmt.getResultSet();

            while(rs.next())
            {
                patient.setPatientID(rs.getString("patientID"));
                patient.setPatientName(rs.getString("patientName"));
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return patient;         
    }
    
}
