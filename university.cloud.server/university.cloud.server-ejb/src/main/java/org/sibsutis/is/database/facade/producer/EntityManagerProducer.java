package org.sibsutis.is.database.facade.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Producer for injectable EntityManager
 *
 */
public class EntityManagerProducer
{

    @Produces
    @PersistenceContext(unitName = "sibsutisdb")
    private EntityManager em;
}
