/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthpointpatientmanage;

import com.afritrend.Patient.PatientCommon;
import com.afritrend.common.DataAccess.UsersDataAccess;
import com.afritrend.common.Model.UsersModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Xavier Khonje
 */
public class HealthPointController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button EXITBTN;
    
    @FXML
    private Button LOGINBTN;
    
    @FXML
    private BorderPane HealthPointMain;
    
    @FXML
    private TextField HPemail;
    
    @FXML
    private PasswordField HPpassword;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
                   
    }    
    
    @FXML
    private void UserLogin(ActionEvent event)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/PatientSearch.fxml"));
            
            //login here
            String email = HPemail.getText();
            String pword = HPpassword.getText(); 
            
            UsersDataAccess userdao = new UsersDataAccess();
            UsersModel usr = new UsersModel();
            usr = userdao.Authenticateusers(email, pword);
            
            if(usr.getfK_idusergroup() == 0)
            {                        
                //No group assigned to...
            }
            else
            {
                if(usr.getEmail().equals(email) && usr.getPassword().equals(pword))
                {			    
//                    session.setAttribute("sessionfirstname", usr.getFirstname());
//                    session.setAttribute("sessionlastname", usr.getLastname());
//                    session.setAttribute("sessiondesignation", usr.getDesignation());
//                    session.setAttribute("sessionemail", usr.getEmail());  
//                    session.setAttribute("sessiongroupid", usr.getfK_idusergroup());          
            
                    Stage stage2 = new Stage();

                    Stage stage = (Stage)LOGINBTN.getScene().getWindow();            
                    //After Authentication move to the Search Patient Screen

                    Scene PatientSearchScene = new Scene(root);

                    stage2.setScene(PatientSearchScene);   
                    stage2.setMaximized(true);

                    stage2.show();
                    stage.close();
                }
                else
                {
                    //Email and Password is a problem
                }
            }              
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    @FXML
    private void ExitHealthPoint(ActionEvent event)
    {
        //release all resources that need to be closed for
        Stage stage = (Stage)EXITBTN.getScene().getWindow();     
        stage.close();
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
