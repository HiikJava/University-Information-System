/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.vaadin;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import org.sibsutis.is.database.facade.StudentFacade;
import org.sibsutis.is.database.model.entity.Student;

/**
 *
 * @author vaganovdv_2
 */
@Singleton
public class StudentService
{
    
    private static final Logger log = Logger.getLogger(StudentService.class.getName());
    private static StudentService instance;

    @EJB
    private StudentFacade studentFacade;
    
    public StudentService()
    {
        log.log(Level.INFO, "Создан экземпляр класса [StudentService]");
    }

    public static StudentService getInstance()
    {
        if (instance == null)
        {
            instance = new StudentService();

        }
        return instance;
    }
    
    
   public void saveStudent(Student student)
   {
   
        log.log(Level.INFO, "Попытка записи экземпляра класса [Student]");
       
       
        
        
            if (studentFacade != null)
        {
            log.log(Level.INFO, "Попытка записи экземпляра класса [Student]");
            studentFacade.create(student);
            log.log(Level.INFO, "Запись завершена");
        } 
        else
         {
             log.log(Level.WARNING, "Невозможно сохранение  экземпляра класса [Student]");
        }
               
       
   }    
  
    

}
