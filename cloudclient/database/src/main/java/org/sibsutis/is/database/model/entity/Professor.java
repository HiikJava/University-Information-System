/**
 This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 @author vaganovdv
 */
@Entity
public class Professor extends Man
{

    /**
     Должность преподователя
     */
    @Basic
    private String Position;

    public String getPosition()
    {
        return this.Position;
    }

    public void setPosition(String Position)
    {
        this.Position = Position;
    }

}
