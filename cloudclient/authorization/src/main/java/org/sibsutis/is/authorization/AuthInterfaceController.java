package org.sibsutis.is.authorization;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 FXML Controller class

 @author Maximus
 */
public class AuthInterfaceController implements Initializable
{
    // лог
    private static final Logger log = Logger.getLogger(AuthInterfaceController.class.getName());
    
    // <editor-fold desc="Переменные">   
        // <editor-fold desc="Авторизация">
        @FXML
        private Label Auth_Login_LB; // Label рядом с вводом логина (Необязательный в качестве перемненной)
        @FXML
        private Label Auth_Pass_LB; // Label рядом с вводом пароля (Необязательный в качестве перемненной) 
        @FXML
        private Label Auth_Save_LB; // Label около ChB сохранения (Необязательный в качестве перемненной)
        @FXML
        private TextField Auth_Login_TF; // TextBox Поле ввода логина
        @FXML
        private TextField Auth_Pass_TF; // TextBox Ввод пароля
        @FXML
        private CheckBox Auth_Save_ChB; // CheckBox для сохранения пароля 
        @FXML
        private Button Auth_Enter_BT; // Button авторизации
        // </editor-fold>
    
        // <editor-fold desc="Регистраия">
        @FXML
        private Label Reg_Surname_LB; // Label рядом с вводом Фамилия (Необязательный в качестве перемненной)               
        @FXML
        private Label Reg_Name_LB; // Label рядом с вводом Имени (Необязательный в качестве перемненной)   
        @FXML
        private Label Reg_Mail_LB; // Label около ввода mail (Необязательный в качестве перемненной)                         
        @FXML
        private Label Reg_Status_LB; // Label около ComboBox с выбором статуса (Необязательный в качестве перемненной)
        @FXML
        private Label Reg_Pass_LB; // Label около ввода ввода пароля (Необязательный в качестве перемненной)                        
        @FXML
        private Label Reg_Middlename_LB; // Label рядом с вводом Отчества (Необязательный в качестве перемненной) 
        @FXML
        private TextField Reg_Surname_TF; // TextBox Поле ввода логина    
        @FXML
        private Button Reg_Registration_BT; // Button регистрации                 
        @FXML
        private PasswordField Reg_Pass_PF; // PasswordField                                                       
        @FXML
        private ComboBox Reg_Status_CB; // Выбор статуса (Сотрудник/Студент)
        @FXML
        private TextField Reg_Name_TF; // TextBox ввод имени
        @FXML
        private TextField Reg_Middlename_TF; // TextBox ввод отчества
        @FXML
        private TextField Reg_Mail_TF; // TextBox ввод mail
        @FXML
        private Label Reg_Mail_Mess_LB; // Label оповещения о использовании e-mail
        @FXML
        private Label Reg_Pass_Mess_LB; // Label оповещения о некорректном пароле 
        // </editor-fold>
    
        // <editor-fold desc="Восстановление пароля">
        @FXML
        private Label Recovery_Mail_LB;
        @FXML
        private Label Recovery_NewPass_LB;
        @FXML
        private Label Recovery_ConfirmPass_LB;
        @FXML
        private Label Recovery_Code_LB;
        @FXML
        private TextField Recovery_Mail_TF; // TextField ввода e-mail
        @FXML
        private Button Recovery_Send_BT; // Button откправки кода восстановления
        @FXML
        private Label Recovery_Mail_Mess_LB; // Label сообщений (mail)
        @FXML
        private TextField Recovery_Code_TF; // TextField ввода кода восстановления
        @FXML
        private PasswordField Recovery_NewPass_TF; // Ввод пароля
        @FXML
        private PasswordField Recovery_ConfirmPass_TF; // Подтверждение пароля 
        @FXML
        private Label Recovery_Code_Mess_LB; // Сообщение (код воссстановления)
        @FXML
        private Label Recovery_NewPass_Mess_LB; // Сообщение (Новый пароль)
        @FXML
        private Label Recovery_ConfirmPass_Mess_LB; // Сообщение (подтверждение пароля)
        @FXML
        private Button Recovery_RestorePass_BT; // Применить восстановления пароля
        // </editor-fold>
    // </editor-fold>
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        log.info("----------------------------------------------------------------------");
        log.info(" ...");
        //ConfigureModules();
        AuthButton();
        RegButton();
        RecoveryButton();
        log.info("Конфигурация зависимых модулей завершена");
        log.info("----------------------------------------------------------------------");
    }    
    
    // <editor-fold desc="Кнопки">
    private void AuthInt_Auth_Enter_BT() // Кнопка авторизации
    {
        AuthButton(); // Процедура авторизация
    }
    
    private void AuthInt_Reg_Registration_BT() // Кнопка регистрации
    {
        RegButton(); // Процедура регистрации
    }
    
    private void AuthInt_Recovery_RestorePass_BT() // Кнопка восстановления
    {
        RecoveryButton(); // Процедура Вост.пароля
    }
    
    private void AuthInt_Recovery_Send_BT() // Кнопка отправки кода восстановления на почту
    {
        RecoverySendButton(); // Процедура отправки кода восстановления на почту
    }
    // </editor-fold>
    
    private void AuthButton() // Процедура авторизация
    {
        Auth_Enter_BT.setOnAction
        ((ActionEvent event) ->
            {   // Обработка нажатия клавиши
                log.log(Level.INFO, "[authorization_Auth] Нажата кнопка {Вход}");  
                log.log(Level.INFO, "[authorization_Auth] Логин: "+this.Auth_Login_TF.getText());  
                log.log(Level.INFO, "[authorization_Auth] Пароль: "+this.Auth_Pass_TF.getText());  
                //log.log(Level.INFO, "[authorization_Auth] Сохранить пароль: "+this.Auth_Save_ChB.get());  
            }
        );
    }
    
    private void RegButton() // Процедура регистрации
    {
       /* Reg_Registration_BT.setOnAction
        ((ActionEvent event) ->
            {   // Обработка нажатия клавиши
                log.log(Level.INFO, "[man.editor] Нажата кнопка добавления студента {Добавить}");  
                log.log(Level.INFO, "[man.editor] Фамилия: "+this.Suname_TF);  
                log.log(Level.INFO, "[man.editor] Имя : "+this.FistName_TF);  
                log.log(Level.INFO, "[man.editor] Отчество: "+this.MiddleName_TF);  
            }
        );*/
    }
    
    private void RecoveryButton() // Процедура вост.пароля
    {/*
        Recovery_RestorePass_BT.setOnAction
        ((ActionEvent event) ->
            {   // Обработка нажатия клавиши
                log.log(Level.INFO, "[man.editor] Нажата кнопка добавления студента {Добавить}");  
                log.log(Level.INFO, "[man.editor] Фамилия: "+this.Suname_TF);  
                log.log(Level.INFO, "[man.editor] Имя : "+this.FistName_TF);  
                log.log(Level.INFO, "[man.editor] Отчество: "+this.MiddleName_TF);  
            }
        );*/
    }
    
    private void RecoverySendButton() // Процедура отправки на почту письма с кодом восстановления
    {/*
        Recovery_Send_BT.setOnAction
        ((ActionEvent event) ->
            {   // Обработка нажатия клавиши
                log.log(Level.INFO, "[man.editor] Нажата кнопка добавления студента {Добавить}");  
                log.log(Level.INFO, "[man.editor] Фамилия: "+this.Suname_TF);  
                log.log(Level.INFO, "[man.editor] Имя : "+this.FistName_TF);  
                log.log(Level.INFO, "[man.editor] Отчество: "+this.MiddleName_TF);  
            }
        );*/
    }

  

}
