package org.sibsutis.is.authorization;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.netbeans.api.settings.ConvertAsProperties;


import org.openide.LifecycleManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */

@ConvertAsProperties(
        dtd = "-//org.sibsutis.is.man.editor//ManEditor//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ManEditorTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.sibsutis.is.man.editor.ManEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ManEditorAction",
        preferredID = "ManEditorTopComponent"
)
@Messages(
        {
            "CTL_ManEditorAction=Редактор персон",
            "CTL_ManEditorTopComponent=Редактор персон",
            "HINT_ManEditorTopComponent=Редактор персон"
        })
@Messages(
        {
            "CTL_ManEditorAction=Редактор персон",
            "CTL_ManEditorTopComponent=Редактор персон",
            "HINT_ManEditorTopComponent=Редактор персон"
        })

public class AuthInterfaceTopComponent extends javax.swing.JPanel implements java.beans.Customizer
{    
    private Object bean;
    private static final Logger log= Logger.getLogger(AuthInterfaceTopComponent.class.getName());
    
    private JFXPanel  fxPanel;
    private AuthInterfaceController controller;
    
    public AuthInterfaceTopComponent()
    {
        initComponents();
        setName(Bundle.CTL_ManEditorTopComponent());
        setToolTipText(Bundle.HINT_ManEditorTopComponent());
        setLayout(new BorderLayout());
        init();
    }
    
    public void setObject(Object bean)
    {
        this.bean = bean;
    }
    
    private void init()
    {
        final CountDownLatch latch = new CountDownLatch(1);
        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);
        Platform.setImplicitExit(false);
        Platform.runLater
        (()-> 
            {
                try
                {
                    createScene();
                }
                finally
                {
                    latch.countDown();
                }
            }
        );
        try
        {
            latch.await(); // wait for createScene() to finish // get the InstanceContent from the controller 
            // associateLookup(new AbstractLookup(controller.getInstanceContent()));
        }
        catch (InterruptedException ex)
        {
            log.log(Level.SEVERE, "Ошибка ожидания загрузки связанных компонент интерфейса");
            log.log(Level.SEVERE, "Описание ошибки [" + ex.getMessage() + "]");
            log.log(Level.SEVERE, "Причина ошибки [" + ex.getMessage() + "]");
            LifecycleManager.getDefault().exit();
        }
    }
    private void createScene()
    {
        try
        {
            log.info("Загрузка сцены для модуля [AuthInterface]... ");
            URL location = getClass().getResource("AuthInterface.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            Scene scene = new Scene(root);
            
            if (scene != null)
            {    
                log.info("Сцена модуля [AuthInterface] загружена успешно ");
                fxPanel.setScene(scene);
                controller = (AuthInterfaceController) fxmlLoader.getController();
                log.info("Модуль [AuthInterface] загружен успешно");                         
            }
            else
            {
               log.log(Level.SEVERE, "Ошибка загрузки сцены модуля [AuthInterface]");
               
            }           
        }
        catch (IOException ex)
        {
            log.info("Инициализация графического интерфейса [AuthInterface] завершилась неудачей");
            log.log(Level.SEVERE, "Описание ошибки: ", ex.toString());
        }
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        setLayout(new java.awt.BorderLayout());

    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
