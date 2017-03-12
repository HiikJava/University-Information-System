
package org.sibsutis.is.man;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Man
{

    private static final Logger log = Logger.getLogger(Man.class.getName());

   
    
    public String getMiddleName()
    {
        log.log(Level.INFO, "   ");
        
        return MiddleName;
    }

    
    public void setMiddleName(String MiddleName)
    {
        this.MiddleName = MiddleName;
    }
    private String FistName;             // Имя человека 
    private  String SureName;         // Фамилия человека     
    private String MiddleName;     // Отчество  человека 
    
  
      public Man (  )
    {
        
       log.log(Level.INFO, "[Man]   Создание экземпляра класса..."); 
      this.FistName = "";
      this.MiddleName = "";
      this.SureName = "";
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
  
    
}
