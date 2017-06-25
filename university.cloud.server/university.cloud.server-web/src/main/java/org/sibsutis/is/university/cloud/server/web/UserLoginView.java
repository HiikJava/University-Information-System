/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.university.cloud.server.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class UserLoginView 
{

    private static final Logger log = Logger.getLogger(UserLoginView.class.getName());
    private String username;
    private String password;
    
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) 
    
    {
        
        log.log(Level.INFO,"[UserLoginView] Обработка данных:");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext fcontext = FacesContext.getCurrentInstance();
        
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null  && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Добро пожаловать: [", username +"]");
        } else 
        {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ошибка регистрации", "Invalid credentials");
            log.log(Level.INFO,"[UserLoginView] Ошибка регистрации");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        
        
        context.addCallbackParam("loggedIn", loggedIn);
    }   
}
