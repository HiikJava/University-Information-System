/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.installer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.sibsutis.is.cloud.ignite.IgniteManagerAPI;

/**
 *
 * @author vaganovdv
 */

@Startup
@Singleton
public class Installer
{

    private static final Logger log = Logger.getLogger(Installer.class.getName());
 
    private static final String ServerName ="Информационная система ХИИК. Версия 0.0.7";
    private static final String BuildDate  ="Дата сборки: 02.05.2017 ";
    
    private boolean r1= false,r2= false,r3= false;
    
    
    // Используемые модули 
    
    @EJB
    private IgniteManagerAPI IgniteManager; // Менеджер облака Ignite
    
    
    
    @PostConstruct
    private void startup() 
    {
        log.log(Level.INFO,"");
        log.log(Level.INFO,"======================================================================");
        log.log(Level.INFO,"");
        log.log(Level.INFO,ServerName);
        log.log(Level.INFO,"(C) Хабаровский инстиут инфокоммуникаций  'Гипрогазцентр' 2017 г.");
        log.log(Level.INFO,"");
        log.log(Level.INFO,BuildDate);
        log.log(Level.INFO,"");
        log.log(Level.INFO,"=======================================================================");
        log.log(Level.INFO,"");
        log.log(Level.INFO,"Старт сервера ...");
        
                r1 = IgniteManager.start();
               
               
        
        if (r1)
        {
            log.log(Level.INFO,"");
            log.log(Level.INFO,"Сервер стартовал успешно");
            log.log(Level.INFO,"");
        }   
        else
        {
            log.log(Level.WARNING,"");
            log.log(Level.WARNING,"Загрузка сервера выполнена с ошибками");
            log.log(Level.WARNING,"");
        }
     
      
        log.log(Level.INFO,"");
           
    }
 
    @PreDestroy
    private void shutdown() 
    {
        log.log(Level.INFO,"");
        log.log(Level.INFO,"");
        log.log(Level.INFO,"======================================================================");
        log.log(Level.INFO,"");
        log.log(Level.INFO,ServerName);
        log.log(Level.INFO,"");
        log.log(Level.INFO,BuildDate);
        log.log(Level.INFO,"Остановка ...");
        
       
        IgniteManager.stop();
        
        log.log(Level.INFO,"Сервер остановлен");
        log.log(Level.INFO,"");
        log.log(Level.INFO,"=======================================================================");
        log.log(Level.INFO,"");
        log.log(Level.INFO,"");
    
    }
    
}
