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
import org.openide.util.Lookup;
import org.sibsutis.is.man.model.Man;
import org.sibsutis.is.man.model.ManManagerAPI;


public class FXMLController implements Initializable
{
    // лог
    private static final Logger log = Logger.getLogger(FXMLController.class.getName());
    private ManManagerAPI  ManManager;

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
        LookingForManManager();
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
            log.log(Level.INFO, "[man.editor] Фамилия: " + this.Suname_TF.getText());
            log.log(Level.INFO, "[man.editor] Имя: " + this.FistName_TF.getText());
            log.log(Level.INFO, "[man.editor] Отчество: " + this.MiddleName_TF.getText());

            Man man = new Man();
            if (!FistName_TF.getText().isEmpty()
                    && !MiddleName_TF.getText().isEmpty()
                    && !Suname_TF.getText().isEmpty())
            {
                man.setFistName(this.FistName_TF.getText());
                man.setMiddleName(MiddleName_TF.getText());
                man.setSureName(Suname_TF.getText());
                
                
            } else
            {
                log.log(Level.INFO, "[man.editor] Не заполнены поля Ф.И.О. сохранение не возможно");
            }

            if (ManManager != null)
            {
                ManManager.addMan(man);
            }

        }
        );
    }

    
    private boolean  saveMan(Man man)
    {
       boolean result = false;   
       if (ManManager != null)
       {
           log.log(Level.INFO,"[ManEditor] Попытка добавления экземпляра класса {Man} выполнение {saveMan}...");
           ManManager.addMan(man);
            log.log(Level.INFO,"[ManEditor] Выполнение операции  {saveMan} завершено");
           
       }  
       
       return result;
    }      
    
     private synchronized boolean LookingForManManager()
    {
        boolean result = false;     
        log.info("[ManEditor] Поиск модуля [ManManager]...");
        ManManager = null;
        ManManager = Lookup.getDefault().lookup(ManManagerAPI.class);
        
        if (ManManager == null)
        {
            log.log(Level.WARNING,"[ManEditor] Невозможно загрузить модуль [ManManger] ");
            result = false;
        } else
        {     
            log.info("[ManEditor] Модуль [ManManager] загружен успешно ");            
         
            result =true;          
        }
        return result;
    }

    
    
    
    
    
    
}