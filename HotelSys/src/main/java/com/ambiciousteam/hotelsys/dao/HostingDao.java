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

//    public List<Hosting> activeHostings() {
//
//        Query createQuery;
//
//        createQuery = getEntityManager().createNativeQuery("SELECT h FROM hosting  AS h, room AS r WHERE h.roomfk_id=r.id AND r.room_status='OCUPADO' AND h.hosting_checkout='false';");
//        return createQuery.getResultList();
//    }

}
