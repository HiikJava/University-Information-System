/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.construction.manager;

/**
 *
 * @author vaganovdv
 */
public interface ConstructionManagerAPI
{
    
    public boolean start();
    public boolean stop();
    
      public boolean addBuilding();
      public boolean removeBuilding(long BuildingID);
      public long       getTotalBuildings();
    
}
