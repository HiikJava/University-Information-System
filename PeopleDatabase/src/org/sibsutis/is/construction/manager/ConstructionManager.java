/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.construction.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.construction.Building;

/**
 *
 * @author vaganovdv
 */
public class ConstructionManager implements  ConstructionManagerAPI
{

    private static final Logger log = Logger.getLogger(ConstructionManager.class.getName());
 // База данных зданий
    private Map <Long,  Building > BuildingDatabase  = new HashMap < >();
      
    
    public ConstructionManager()
    {
        log.log(Level.INFO,"[ConstructionManager]   Создан экземпляр класса"  );
    }

    @Override
    public boolean start()
    {
        boolean result = false;
        int records = BuildingDatabase.size();
        log.log(Level.INFO,"[ConstructionManager]   база данных зданий содержит {" +records+"} записей" );
        result = true;
        
        return result;
    }

    @Override
    public boolean stop()
    {
       boolean result = false;
        BuildingDatabase.clear();
        log.log(Level.INFO,"[ConstructionManager]   база данных зданий   очищена" );
        result = true;
        
        return result;
    }

    @Override
    public boolean addBuilding()
    {
         boolean result = false;
         Building  building= new Building ();
         long count = 0;
         count = BuildingDatabase.size()+1;
         
         BuildingDatabase.put(count, building);
         result = true;
         return result;
    }

    @Override
    public boolean removeBuilding(long BuildingID)
    {
         boolean result = false;
        
         
         BuildingDatabase.remove(BuildingID);
         
         return result;
    }

    @Override
    public long getTotalBuildings()
    {
          return  BuildingDatabase.size();
    }
    
    
    
    
}
