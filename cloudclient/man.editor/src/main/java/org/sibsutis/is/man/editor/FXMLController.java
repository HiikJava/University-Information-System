package org.sibsutis.is.man.editor;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.Initializable;


public class FXMLController implements Initializable
{

// лог
    private static final Logger log = Logger.getLogger(FXMLController.class.getName());


  
    




    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        log.info("----------------------------------------------------------------------");
        log.info("Конфигурация зависимых модулей ...");
        //ConfigureModules();
        //ConfigureButtons();
        log.info("Конфигурация зависимых модулей завершена");
        log.info("----------------------------------------------------------------------");
    }

}