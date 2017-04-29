/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.sibsutis.is.man.model.Man;

/**
 *
 * @author vaganovdv
 */


public class IgniteManager implements IgniteManagerAPI
{
    private static final Logger log = Logger.getLogger(IgniteManager.class.getName());
    
    private static Ignite ignite;
    
   
    @Override
    public boolean start()
    {
        boolean result = false;
        log.log(Level.INFO, "[IgniteManager] Старт");

      
           ignite = Ignition.start();
           result = true;

            IgniteCache<Integer, Man> cache = ignite.getOrCreateCache("man.model");

      
            
            Man man1 = new Man();
            man1.setFistName("Владимир");
            man1.setMiddleName("Владимирович");
            man1.setSureName("Путин");
            cache.put(1,man1);
            
            
            Man man2 = new Man();
            man2.setFistName("Владимир");
            man2.setMiddleName("Вольфович");
            man2.setSureName("Жириновский");
            cache.put(2,man2);
            
            
            

            for (int i = 1; i < 3; i++)
            {
                    Man man = new Man();
                    man = cache.get(i);
                     log.log(Level.INFO,"Got [key=" + i + ", val=" + man.getFullName() + ']');
            }
      

        log.log(Level.INFO, "[IgniteManager] Стартовал");
        return result;
    }

    @Override
    public boolean stop()
    {
        boolean result = false;
        log.log(Level.INFO, "[IgniteManager] Остановка");

        try
        {
         
            if (ignite != null)
            {
                ignite.close();
                result = true;
                log.log(Level.INFO, "[IgniteManager] Остановлен");
            } else
            {
                result = false;
                log.log(Level.WARNING, "[IgniteManager] Экземпляр класса не существует - остановка невозможна");
            }
        } catch (IgniteException ex)
        {
            log.log(Level.WARNING, "[IgniteManager] Ошибка остановки модуля ");
            log.log(Level.WARNING, "[IgniteManager] Описание ошибки: [" + ex.toString() + "]");
        }

        return result;
    }
}
