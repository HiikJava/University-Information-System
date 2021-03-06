
package org.sibsutis.is.university.cloud.server.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import org.sibsutis.is.database.facade.StudentFacade;
import javax.faces.bean.ManagedBean;
import org.sibsutis.is.cloud.ignite.IgniteManager;
/**
 *
 * @author developer
 */



@ManagedBean

public class terminalView 
{
    private static final Logger log = Logger.getLogger(IgniteManager.class.getName());
    
    @Resource SessionContext ctx; 
    
    private String firstname;
    private String lastname;
    private String middlename;
    private String fullname;
    
    @EJB
    private StudentFacade studentFacade;
        

    public String handleCommand(String command, String[] params) {
        if(command.equals("greet")) 
        {
            return "В базе данных студентов: "+studentFacade.count();
        }
        else {
            return "it's bad";
        }
    }
    
    public String getfirstname(){
        return firstname;
    }
    public void setfirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getlastname(){
        return lastname;
    }
    public void setlastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getmiddlename(){
        return middlename;
    }
    public void setmiddlename(String middlename){
        this.middlename = middlename;
    }
    
    public String getfullname(){
        if (lastname!=null){
                fullname = lastname+" "+firstname+" "+middlename;
                log.log(Level.INFO, "[terminalView] полное имя: "+fullname);
            
               
                
               
                 String SessionUser ="Не указан"; 
                        SessionUser = ctx.getCallerPrincipal().getName();
                log.log(Level.INFO, "[terminalView] Login user: "+fullname);
                 
                 
        }else{
                fullname = "";
             }
        return fullname;
    }
}