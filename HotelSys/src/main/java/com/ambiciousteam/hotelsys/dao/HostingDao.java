package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Hosting;
import java.io.Serializable;

/**
 *
 * @author cassio
 */
public class HostingDao extends AbstractDao<Hosting> implements Serializable {

    public HostingDao() {
        super(Hosting.class);
    }

//    public List<Individual> hostedName() {
//        Query createQuery;
//
//        createQuery = getEntityManager().createQuery("SELECT i.name FROM Individual AS i, Hosting AS h, Room AS r WHERE i.id=h.individualFK AND r.status='OCUPADO'");
//        return createQuery.getResultList();
//    }

}
