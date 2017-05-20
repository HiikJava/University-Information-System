/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CachePeekMode;
import org.apache.ignite.transactions.Transaction;
import static org.apache.ignite.transactions.TransactionConcurrency.PESSIMISTIC;
import static org.apache.ignite.transactions.TransactionIsolation.REPEATABLE_READ;

/**
 *
 * @author vaganovdv
 */

@Singleton
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
           if (ignite.active())
           {    
           
           result = true;
             log.log(Level.INFO, "[IgniteManager] Стартовал успешно");
           }
           else
           {
                    
               log.log(Level.INFO, "[IgniteManager] Ошибка старта {Ignite}");
           }

           /*
           
            IgniteCache<Long, Man> cache = ignite.getOrCreateCache("man.model");
            
      try (Transaction tx = ignite.transactions().txStart(PESSIMISTIC, REPEATABLE_READ))
       {   
            
            Man man1 = new Man();
            man1.setFistName("Владимир");
            man1.setMiddleName("Владимирович");
            man1.setSureName("Путин");
            man1.setId(5L);
            cache.put(5L,man1);
            log.log(Level.INFO,"[IgniteManager] Размещено в кеше ["+cache.getName()+"] --> { "+man1.getFullName()+" }");
            
            
            Man man2 = new Man();
            man2.setFistName("Владимир");
            man2.setMiddleName("Вольфович");
            man2.setSureName("Жириновский");
            man2.setId(6L);
            cache.put(6L,man2);
            log.log(Level.INFO,"[IgniteManager] Размещено в кеше ["+cache.getName()+"] --> { "+man2.getFullName()+" }");
            
            
            log.log(Level.INFO,"Создание тестовых экземпляров закончено");
            log.log(Level.INFO,"Тестовые экземпляры размещены в кэше");
            
            tx.commit();
            
       }   
            
            log.log(Level.INFO,"[IgniteManager] Размер кэша [man.model] ---> {"+cache.sizeLong(CachePeekMode.PRIMARY)+"}");
           // log.log(Level.INFO,"Попытка получения данных из кэша");
            
           /*
            long key = 0L;
                    Man man3 = new Man();
                    man3 = cache.get(key);
                    log.log(Level.INFO,"Получено из кэша [ ключ=" + key + ", значение =" + man3.getFullName() + ']');
           
                    Man man4 = new Man();
                    man4 = cache.get(key);
                    log.log(Level.INFO,"Получено из кэша [ ключ=" + key + ", значение =" + man3.getFullName() + ']');
           
             */       
                    
                    
      
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
