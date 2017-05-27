/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.database.manager;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import org.sibsutis.is.database.facade.StudentFacade;
import org.sibsutis.is.database.model.entity.Student;

/**
 *
 * @author vaganovdv
 */
@Singleton
public class PersonManager
{

    @EJB
    private StudentFacade studentFacade;

    public void start()
    {
        Student student  =new Student();
        student.setName("Владимир");
        student.setSureName("Путин");
        studentFacade.create(student);
        
        
    }
    
    
    
}
