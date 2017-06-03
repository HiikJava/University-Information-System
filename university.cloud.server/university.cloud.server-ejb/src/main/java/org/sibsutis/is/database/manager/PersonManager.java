/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.database.manager;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import org.sibsutis.is.database.facade.EmployeeFacade;
import org.sibsutis.is.database.facade.StudentFacade;
import org.sibsutis.is.database.facade.StudentGroupFacade;
import org.sibsutis.is.database.model.entity.Employee;
import org.sibsutis.is.database.model.entity.Student;
import org.sibsutis.is.database.model.entity.StudentGroup;

/**
 *
 * @author vaganovdv
 */
@Singleton
public class PersonManager
{

    @EJB
    private StudentGroupFacade studentGroupFacade;

    @EJB
    private EmployeeFacade employeeFacade;

    @EJB
    private StudentFacade studentFacade;
    
    
    
    

    public void start()
    {
        Student student1  =new Student();
        student1.setName("Владимир");
        student1.setMiddleName("Владимирович");
        student1.setSureName("Путин");
        studentFacade.create(student1);
        
        Student student2  =new Student();
        student2.setName("Владимир");
        student1.setMiddleName("Вольфович");
        student2.setSureName("Жириновский");
        studentFacade.create(student2);
        
        Employee employee =new    Employee ();
        employee.setName("Владимир");
        employee.setSureName("Жириновский");
        employee.setMiddleName("Вольфович");
        employee.setPosition("Директор ХИИК");
        employeeFacade.create(employee);
        
        StudentGroup  studentGroup = new StudentGroup();
        List <Student> StudentDatabase =new ArrayList<>();
        StudentDatabase.add(student1);
        StudentDatabase.add(student2);
        
        studentGroup.setStudents(StudentDatabase);
       
        studentGroupFacade.create(studentGroup);
        
    }
    
    
    
}
