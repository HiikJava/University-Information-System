/**
 * This file was generated by the Jeddict
 */
package org.sibsutis.is.database.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Группа студентов
 *
 * @author vaganovdv
 */
@Entity
public class StudentGroup
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(targetEntity = Student.class)
    private List<Student> students;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Student> getStudents()
    {
        return this.students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

}
