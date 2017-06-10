/**
 This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 @author Maximus
 */
@Entity
public class Disciplines extends Document
{

    @ElementCollection
    private List<String> Discipline;

    @ElementCollection
    private List<String> Mark;

    public List<String> getDiscipline()
    {
        return this.Discipline;
    }

    public void setDiscipline(List<String> Discipline)
    {
        this.Discipline = Discipline;
    }

    public List<String> getMark()
    {
        return this.Mark;
    }

    public void setMark(List<String> Mark)
    {
        this.Mark = Mark;
    }

}
