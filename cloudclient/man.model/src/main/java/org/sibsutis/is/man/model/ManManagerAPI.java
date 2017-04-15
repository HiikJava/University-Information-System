/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.man.model;

import java.beans.PropertyChangeListener;

/**
 *
 * @author vaganovdv
 */
public interface ManManagerAPI
{
      public boolean addMan(Man man);
       public  void addPropertyChangeListener(PropertyChangeListener listener);
         public  void removePropertyChangeListener(PropertyChangeListener listener);
}
