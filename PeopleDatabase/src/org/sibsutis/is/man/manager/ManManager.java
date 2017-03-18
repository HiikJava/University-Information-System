/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.man.Man;

/**
 *
 * @author vaganovdv
 */
public class ManManager implements ManManagerAPI
{

    private static final Logger log = Logger.getLogger(ManManager.class.getName());
    
    private Map <Long,Man>ManDatabase = new HashMap<>();

    public ManManager()
    {
        
        log.log(Level.INFO,"[ManManager]  Менеджер создан  успешно");
                
    }

    
    
    
    @Override
    public Man createMan()
    {
       
        Man man = new Man();
        if (man != null)
        {
           
            log.log(Level.INFO,"[ManManager]  Экземпляр класса [Man] создан успешно");
                
        } 
        else 
        {
            
            log.log(Level.WARNING,"[ManManager]  Экземпляр класса [Man]  не  создан ");
        }  
        return man;
    }

    @Override
    public boolean addMan(Man man)
    {
        boolean result = false;
        if (!ManDatabase.containsKey(man.getId()))
        {
              ManDatabase.put( man.getId(), man);
              log.log(Level.INFO,"[ManManager]  Экземпляр класса [Man]  добавлен в локальную базу успешно");
              getDatabaseSize();
        } else
        {
             log.log(Level.WARNING,"[ManManager]  Запись с id = ["+man.getId()+"] существует и не может быть добавлена");
        }
        return result;
    }
    
    
    private void getDatabaseSize()
    {
                int s = ManDatabase.size();
                log.log(Level.INFO,"[ManManager]  Размер базы данных [Mandatabase ]= ["+s+"]");
                
    }      
}
