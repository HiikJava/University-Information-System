package org.sibsutis.is.rooms.manager;

public interface RoomManagerAPI 
{
    public boolean start();
    public boolean stop();
    
    public boolean addRoom();
    public boolean removeRoom(long RoomID);
    public long getTotalRoom();   
}
