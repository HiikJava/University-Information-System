/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 *
 * @author vaganovdv_2
 */
public class IgniteConfigurator
{

    private static final Logger log = Logger.getLogger(IgniteConfigurator.class.getName());
    private IgniteConfiguration igniteConfiguration;

    public IgniteConfigurator()
    {
        log.log(Level.INFO, "");
        
    }
    
    
    
      public IgniteConfiguration getIgniteConfiguration()
    {
        return igniteConfiguration;
    }

    public void setIgniteConfiguration(IgniteConfiguration igniteConfiguration)
    {
        this.igniteConfiguration = igniteConfiguration;
    }
    
    
    
}
