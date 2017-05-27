package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.sibsutis.is.database.model.entity.Policy;

@Stateless
@Named("policy")
public class PolicyFacade extends AbstractFacade<Policy, Long>
{

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public PolicyFacade()
    {
        super(Policy.class);
    }

}
