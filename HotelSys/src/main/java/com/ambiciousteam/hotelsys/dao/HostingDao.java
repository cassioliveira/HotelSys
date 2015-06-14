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

}
