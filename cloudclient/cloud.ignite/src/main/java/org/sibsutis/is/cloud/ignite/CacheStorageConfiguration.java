package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.cache.configuration.FactoryBuilder;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

/**

 @author vaganovdv
 */
public class CacheStorageConfiguration
{
    private static final Logger log = Logger.getLogger(CacheStorageConfiguration.class.getName());
    private IgniteConfiguration cfg;

    public CacheStorageConfiguration(IgniteConfiguration cfg)
    {
        this.cfg = cfg;
        log.log(Level.INFO, "[CacheStorageConfiguration] создан экземпляр классаа");
    }

    private void addCacheStoreConfiguration(String Name, String StorageClassName)
    {
        log.log(Level.INFO, "[CacheStorageConfiguration] Добавление конфигурации c именем {" + Name + "}");

        CacheConfiguration configuration = new CacheConfiguration();
        configuration.setName(Name);
        configuration.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);

        configuration.setCacheStoreFactory(FactoryBuilder.factoryOf(StorageClassName));
        configuration.setReadThrough(true);
        configuration.setWriteThrough(true);
        configuration.setWriteBehindEnabled(true);

        cfg.setCacheConfiguration(configuration);

        log.log(Level.INFO, "[CacheStorageConfiguration] Конфигурация  {" + Name + "}  добавлена");
    }

}
