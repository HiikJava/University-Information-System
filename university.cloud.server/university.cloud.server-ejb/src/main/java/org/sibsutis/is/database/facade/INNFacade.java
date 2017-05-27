package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.sibsutis.is.database.model.entity.INN;

@Stateless
@Named("INN")
public class INNFacade extends AbstractFacade<INN, Long>
{

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public INNFacade()
    {
        super(INN.class);
    }

}
