/**
 This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 @author Vadim
 */
@Entity
public class Subject
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(targetEntity = Information_of_Works.class)
    private List<Information_of_Works> information_of_Workses;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Information_of_Works> getInformation_of_Workses()
    {
        return this.information_of_Workses;
    }

    public void setInformation_of_Workses(List<Information_of_Works> information_of_Workses)
    {
        this.information_of_Workses = information_of_Workses;
    }

}
