/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.manager;

import org.sibsutis.is.man.Man;

/**
 *
 * @author vaganovdv
 */
public interface ManManagerAPI
{
    
    public Man createMan ();
    public boolean addMan(Man man);
    
    
    
}
