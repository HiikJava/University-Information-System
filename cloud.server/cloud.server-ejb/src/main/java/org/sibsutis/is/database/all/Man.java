package org.sibsutis.is.database.all;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Man implements Serializable
{

   

    private static final Logger log = Logger.getLogger(Man.class.getName());

    private long id;                            // Идентификатор человека в БД
    private String FistName;                    // Имя человека 
    private String SureName;                    // Фамилия человека     
    private String MiddleName;                  // Отчество  человека 
    private LocalDateTime BirthDate;          //Дата рождения
    private AbstractLocation BirthLocation;
    private static long count = 0L;
    //private Integer Row;
    public int Row;
    private List<AbstractPoint> PointList = new ArrayList<>();
    
    public Man()
    {
        this.id = 0L;
        this.FistName   = "";
        this.MiddleName = "";
        this.SureName   = "";
        log.log(Level.INFO, "[Man] Создан пустой экземпляр класса, id = ["+this.id+"]");
    }

    public String getFistName()
    {
        return ""+FistName;
    }

    public void setFistName(String FistName)
    {
        this.FistName = FistName;
    }

    public String getSureName()
    {
        return ""+SureName;
    }

    public void setSureName(String SureName)
    {
        this.SureName = SureName;
    }

    public String getFullName()
    {
        return ""+getFistName() + " " + this.getMiddleName() + " " + this.getSureName();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setMiddleName(String MiddleName)
    {
        this.MiddleName = MiddleName;
    }

    public String getMiddleName()
    {
        
        return ""+MiddleName;
    }
    /*
    public Integer getRow()
    {
        return Row;
    }

    public void setRow(Integer FistName)
    {
        this.Row = Row;
    }*/
    
     public List<AbstractPoint> getPointList()
    {
        return PointList;
    }

    public void setPointList(List<AbstractPoint> PointList)
    {
        this.PointList = PointList;
    }
    
}
