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

            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("man.model");

            // Store keys in cache (values will end up on different cache nodes).
            for (int i = 0; i < 10; i++)
            {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++)
            {
                     log.log(Level.INFO,"Got [key=" + i + ", val=" + cache.get(i) + ']');
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
