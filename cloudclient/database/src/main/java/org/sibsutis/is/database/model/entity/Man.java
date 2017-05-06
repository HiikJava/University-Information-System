/**
 This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 @author vaganovdv
 */
@MappedSuperclass
public abstract class Man
{

    @Id
    @GeneratedValue(generator = "man_Generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "man_Generator", sequenceName = "Man_Sequens")
    private Long id;

    @Basic
    private String SureName;

    @Basic
    private String Name;

    @Basic
    private String MiddleName;

    @ElementCollection
    private Map<String, String> Map;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSureName()
    {
        return this.SureName;
    }

    public void setSureName(String SureName)
    {
        this.SureName = SureName;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getMiddleName()
    {
        return this.MiddleName;
    }

    public void setMiddleName(String MiddleName)
    {
        this.MiddleName = MiddleName;
    }

    public Map<String, String> getMap()
    {
        return this.Map;
    }

    public void setMap(Map<String, String> Map)
    {
        this.Map = Map;
    }

}
