package org.sibsutis.is.osgitest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator 
{
    
    private String ModuleName; 
    private List <Bundle> BundleList = new ArrayList<>() ;
    
    private static final Logger log = Logger.getLogger(Activator.class.getName());

    public void start(BundleContext context) throws Exception 
    {
       ModuleName =  context.getBundle().getSymbolicName();
       this.getBundleList(context);
       log.log(Level.INFO,"Модуль стартовал");
       log.log(Level.INFO,"Имя модуля: {"+ModuleName+"}");
       
    }

    public void stop(BundleContext context) throws Exception 
    {
       log.log(Level.INFO,"Модуль остановлен");
       log.log(Level.INFO,"Имя модуля: {"+ModuleName+"}");
    }

    
    
      private void getBundleList(BundleContext ctx)
    {
        Bundle [] bundles = null; 
        List<Bundle> TotalBundleList = new ArrayList<>(); 
        log.log(Level.INFO, "Получение списка модулей..");

        if (ctx !=null)
        {
            bundles = ctx.getBundles();
            TotalBundleList = new ArrayList<>(Arrays.asList(bundles)); 
            log.log(Level.INFO, "Общее количество модулей: {"+TotalBundleList.size()+"}");
            
            
            
        BundleList = TotalBundleList.stream().filter
        (b -> 
                b.getSymbolicName().startsWith("org.sibsutis.is")
              
        ).collect(Collectors.toList());
        
        
           log.log(Level.INFO, "Количество программых ХИИК: {"+BundleList.size()+"}");
        }  
        
        
        
    }
    
}
