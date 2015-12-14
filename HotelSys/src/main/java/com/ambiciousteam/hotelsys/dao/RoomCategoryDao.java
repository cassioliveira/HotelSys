package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.RoomCategory;
import java.io.Serializable;

/**
 *
 * @author cassio
 */
public class RoomCategoryDao extends AbstractDao<RoomCategory> implements Serializable {

    public RoomCategoryDao() {
        super(RoomCategory.class);
    }

}
