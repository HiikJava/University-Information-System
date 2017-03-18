package org.sibsutis.is.construction.manager;

public interface ConstructionManagerAPI
{
    
    public boolean start();
    public boolean stop();
    
    public boolean addBuilding();
    public boolean removeBuilding(long BuildingID);
    public long getTotalBuildings();  
}
