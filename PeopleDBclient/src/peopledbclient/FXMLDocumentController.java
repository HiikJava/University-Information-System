/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopledbclient;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author vaganovdv
 */
public class FXMLDocumentController implements Initializable
{

    private static final Logger log = Logger.getLogger(FXMLDocumentController.class.getName());
    
    @FXML
    private Button  SaveMan;
      @FXML
    private TextField SureName;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ConfigureCreateCpsButton();
    }    
    
       private void ConfigureCreateCpsButton()
    {
        SaveMan.setOnAction((ActionEvent event) ->
        {// Обработка нажатия клавиши

            
           
            log.log(Level.INFO, " [] Нажата кнопка создания: {Создать}");
            
             String  sn = SureName.getText();
             log.log(Level.INFO, " [] Фамилия: "+sn);
             
        
        } // Обработка нажатия клавиши
        );

    }

    
    
}
