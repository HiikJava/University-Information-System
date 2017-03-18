package org.sibsutis.is.construction;

import java.util.List;

public class Building extends AbstractConstruction
{
    private String Floor;
    private List<Room> Rooms;

    public Building()
    {
        Floor = "";
        this.Rooms.clear();
    }  
}
