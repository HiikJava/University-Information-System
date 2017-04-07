package org.sibsutis.is.man.editor;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class FXMLController implements Initializable
{
    // лог
    private static final Logger log = Logger.getLogger(FXMLController.class.getName());

    // Форма регистрации студента 
    @FXML
    private TextField Suname_TF;
    @FXML
    private TextField FistName_TF;
    @FXML
    private TextField MiddleName_TF;
    @FXML
    private Button Add_Person_BT;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        log.info("----------------------------------------------------------------------");
        log.info(" ...");
        //ConfigureModules();
        ConfigureButtons();
        log.info("Конфигурация зависимых модулей завершена");
        log.info("----------------------------------------------------------------------");
    }

    private void ConfigureButtons()
    {
        Configure_Add_Person_BT();
    }

    private void Configure_Add_Person_BT()
    {
        Add_Person_BT.setOnAction(
                (ActionEvent event) ->
            {   // Обработка нажатия клавиши
                log.log(Level.INFO, "[man.editor] Нажата кнопка добавления студента {Добавить}");  
                log.log(Level.INFO, "[man.editor] Фамилия: "+this.Suname_TF);  
                log.log(Level.INFO, "[man.editor] Имя : "+this.FistName_TF);  
                log.log(Level.INFO, "[man.editor] Отчество: "+this.MiddleName_TF);  
            }
        );
    }

}