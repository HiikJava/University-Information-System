/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.rooms.manager;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import org.sibsutis.is.construction.Building;
import org.sibsutis.is.construction.Room;

public class RoomManager implements RoomManagerAPI
{
    private static final Logger log = Logger.getLogger(RoomManager.class.getName());
    
    private Map <Long,  Room > RoomDatabase  = new HashMap < >();

    @Override
    public boolean start() 
    {
        boolean result = false;
        int records = RoomDatabase.size();
        log.log(Level.INFO,"[RoomManager] В базе данных комнат содержит {" + records + "} записей" );
        result = true;
        
        return result;
    }

    @Override
    public boolean stop() 
    {
        boolean result = false;
        RoomDatabase.clear();
        log.log(Level.INFO,"[RoomManager] База данных комнат очищена" );
        result = true;
        
        return result;
    }

    @Override
    public boolean addRoom() 
    {
        boolean result = false;
        Room room = new Room();
        long count = 0;
        count = RoomDatabase.size()+1;
        RoomDatabase.put(count, room);
        result = true;
        
        return result;
    }

    @Override
    public boolean removeRoom(long RoomID) 
    {
        boolean result = false;
        RoomDatabase.remove(RoomID);
         
        return result;
    }

    @Override
    public long getTotalRoom() 
    {
        return  RoomDatabase.size();
    }
    
}
