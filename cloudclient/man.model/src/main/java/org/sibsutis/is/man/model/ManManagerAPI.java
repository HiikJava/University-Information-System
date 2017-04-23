/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package org.sibsutis.is.man.model;

import java.beans.PropertyChangeListener;
import java.util.List;

/**

 @author vaganovdv
 */
public interface ManManagerAPI
{
    public static final String EVENT_ADD_MAN = "addMan";
    public static final String EVENT_REMOVE_MAN = "removeMan";
    public boolean addMan(Man man);
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public void removePropertyChangeListener(PropertyChangeListener listener);
    //public boolean deleteMan(Man man);
    public List<Man> getAllMan();
}
