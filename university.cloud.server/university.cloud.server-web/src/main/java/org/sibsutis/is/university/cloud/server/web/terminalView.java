
package org.sibsutis.is.university.cloud.server.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.sibsutis.is.database.facade.StudentFacade;
/**
 *
 * @author developer
 */



@ManagedBean
public class terminalView 
{

    @EJB
    private StudentFacade studentFacade;

    public String handleCommand(String command, String[] params) {
        if(command.equals("greet")) {
            return "В базе данных студентов: "+studentFacade.count();
        }
        else {
            return "it's bad";
        }
        
}
}
