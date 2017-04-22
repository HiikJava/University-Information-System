/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.manager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
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
     // Установка слушателей
    private PropertyChangeSupport propChangeSupport = null;
    
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
             result =false;
           } 
           else
           {
                ManDatabase.put(man.getId(), man);
                
                // Генерация события добавления человкеп
                getPropertyChangeSupport().firePropertyChange(ManManagerAPI.EVENT_ADD_MAN, null, man);
                log.log(Level.INFO, "[ManManager]  экземпляр [Man]  id = ["+man.getId()+"]  успешно добавлен  в БД");
                result =true;
           }
           
       }  
       else
       {
       log.log(Level.WARNING, "[ManManager] Невозможно добавить пустой экземпляр [Man]");
       result =false;
       }
       
       return result;
    }
    
    
    private PropertyChangeSupport getPropertyChangeSupport()
    {
        if (this.propChangeSupport == null)
        {
            this.propChangeSupport = new PropertyChangeSupport(this);
        }
        return this.propChangeSupport;
    }
    
    
    
   
    @Override
    public synchronized void addPropertyChangeListener(PropertyChangeListener listener)
    {
        getPropertyChangeSupport().addPropertyChangeListener(listener);
        log.log(Level.INFO, "" );
        log.log(Level.INFO, "---------------------------------------------------------------" );
        log.log(Level.INFO, "===LISTENER===" );
        log.log(Level.INFO, "[ManManager] Установлен слушатель" );
        log.log(Level.INFO, "[ManManager] Имя слушателя: ["+listener.toString()+"]" );
        log.log(Level.INFO, "---------------------------------------------------------------" );
        log.log(Level.INFO, "" );
    }
    
   
    @Override
    public synchronized void removePropertyChangeListener(PropertyChangeListener listener)
    {
        getPropertyChangeSupport().removePropertyChangeListener(listener);
        log.log(Level.INFO, "" );
        log.log(Level.INFO, "---------------------------------------------------------------" );
        log.log(Level.INFO, "===LISTENER===" );
        log.log(Level.INFO, "[ManManager] Удален слушатель" );
        log.log(Level.INFO, "[ManManager] Имя слушателя: ["+listener.toString()+"]" );
        log.log(Level.INFO, "---------------------------------------------------------------" );
        log.log(Level.INFO, "" );
    }

    @Override
    public List<Man> getAllMan()
    {
       return  new ArrayList<Man>(ManDatabase.values());
    }
}
