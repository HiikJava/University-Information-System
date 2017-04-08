/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;
import org.sibsutis.is.man.model.Man;
import org.sibsutis.is.man.model.ManManagerAPI;

/**
 *
 * @author vaganovdv
 */

@ServiceProvider(service = ManManagerAPI.class)
public class ManManager implements ManManagerAPI
{
 
    private static final Logger log = Logger.getLogger(ManManager.class.getName());
    
    
    private final ConcurrentMap <Long,  Man > ManDatabase  = new ConcurrentHashMap < >();

    @Override
    public boolean addMan(Man man)
    {
       boolean result = false;
       if (man !=null)
       {
       
           if (ManDatabase.containsKey(man.getId()))
           {
            log.log(Level.WARNING, "[ManManager] Невозможно  экземпляр [Man] класса - id = ["+man.getId()+"] существует в БД");
           } 
           else
           {
                ManDatabase.put(man.getId(), man);
                 log.log(Level.INFO, "[ManManager]  экземпляр [Man]  id = ["+man.getId()+"]  успешно добавлен  в БД");
           }
           
       }  
       else
       {
       log.log(Level.WARNING, "[ManManager] Невозможно добавить пустой экземпляр [Man]");
       }
       
       return result;
    }
    
}
