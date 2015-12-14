package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.HostingCategory;
import java.io.Serializable;

/**
 *
 * @author cassio
 */
public class HostingCategoryDao extends AbstractDao<HostingCategory> implements Serializable {

    public HostingCategoryDao() {
        super(HostingCategory.class);
    }

}
