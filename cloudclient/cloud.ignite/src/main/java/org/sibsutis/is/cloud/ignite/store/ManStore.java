/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite.store;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.sibsutis.is.database.all.Man;

/**
 *
 * @author vaganovdv
 */
public class ManStore extends CacheStoreAdapter<Long, Man> 
{

    private static final Logger log = Logger.getLogger(ManStore.class.getName());

    @Override
    public Man load(Long k) throws CacheLoaderException
    {
      
        Man man = new Man();
        man.setId(1L);
        log.log(Level.INFO,"[ManStore] Загрузка экземпляра {Man} --> {LOAD}");
        return man;
    }

    @Override
    public void write(Cache.Entry<? extends Long, ? extends Man> entry) throws CacheWriterException
    {
         log.log(Level.INFO,"[ManStore]  Запись экземпляра {Man} --> {WRITE}");
    }

    @Override
    public void delete(Object o) throws CacheWriterException
    {
        log.log(Level.INFO,"[ManStore]  Удаление экземпляра {Man} --> {DELETE}");
    }
    
}
