
package org.sibsutis.is.location;


public class AbstractLocation
{

    
    private String Country;
    private String Region;
    private String State;
    private String City;
    private String Village;
    private AbstractPoint Point;
    private GpsPoint GPSPoint;

    public String getVillage()
    {
        return Village;
    }

    public void setVillage(String Village)
    {
        this.Village = Village;
    }


    public String getCity()
    {
        return City;
    }

    public void setCity(String City)
    {
        this.City = City;
    }


    public String getState()
    {
        return State;
    }

    public void setState(String State)
    {
        this.State = State;
    }


    public String getRegion()
    {
        return Region;
    }

    public void setRegion(String Region)
    {
        this.Region = Region;
    }


    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String Country)
    {
        this.Country = Country;
    }

    
}
