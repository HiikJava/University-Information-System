package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.sibsutis.is.database.model.entity.SNILS;

@Stateless
@Named("SNILS")
public class SNILSFacade extends AbstractFacade<SNILS, Long>
{

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public SNILSFacade()
    {
        super(SNILS.class);
    }

}
