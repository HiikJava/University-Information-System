/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.cloud.ignite;

import javax.ejb.Local;

/**
 *
 * @author vaganovdv
 */
@Local
public interface IgniteManagerAPI
{
       public boolean start();
       public boolean stop(); 
}
