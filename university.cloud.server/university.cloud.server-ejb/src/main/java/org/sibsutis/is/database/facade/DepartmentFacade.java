package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import org.sibsutis.is.database.model.entity.Department;

@Stateless
@Named("department")
public class DepartmentFacade extends AbstractFacade<Department, Long>
{

     @PersistenceContext(unitName = "SIBSUTIS_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public DepartmentFacade()
    {
        super(Department.class);
    }

}
