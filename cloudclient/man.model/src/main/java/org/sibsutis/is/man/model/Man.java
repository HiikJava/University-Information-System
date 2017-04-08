
package org.sibsutis.is.man.model;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.location.AbstractLocation;


public class Man
{

    private static final Logger log = Logger.getLogger(Man.class.getName());
    

    private long id;                                        // Идентификатор человека в БД
    private String FistName;                        // Имя человека 
    private String SureName;                        // Фамилия человека     
    private String MiddleName;                     // Отчество  человека 
    private LocalDateTime   BirthDate;          //Дата рождения
    private AbstractLocation BirthLocation;
    private static long count=0L;
    
    
    
    

    public Man (  )
    {        
        log.log(Level.INFO, "[Man]   Создание экземпляра класса..."); 
        this.FistName       =  "";
        this.MiddleName  = "";
        this.SureName      =  "";
        this.count++;
        this.id = count;
        log.log(Level.INFO, "[Man]   Создание экземпляра класса закончено");   
    }       
    
     public String getFistName()
    {
        return FistName;
    }

    
    public void setFistName(String FistName)
    {
        this.FistName = FistName;
    }

   
    public String getSureName()
    {
        return SureName;
    }

    
    public void setSureName(String SureName)
    {
        this.SureName = SureName;
    }

    public String getFullName ()
    {
        return this.getFistName()+" "+this.getMiddleName()+" "+this.getSureName();    
    }    
    
        public long getId()
    {
        return id;
    }

   
    public void setId(long id)
    {
        this.id = id;
    }
    
      
    public void setMiddleName(String MiddleName)
    {
        this.MiddleName = MiddleName;
    }
    
    
    public String getMiddleName()
    {
        log.log(Level.INFO, "   ");        
        return MiddleName;
    }
}
