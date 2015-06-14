package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Room;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author cassio
 */
public class RoomDao extends AbstractDao<Room> implements Serializable {

    public RoomDao() {
        super(Room.class);
    }

    public List<Room> busyRooms() {
        Query createQuery = null;

        createQuery = getEntityManager().createNativeQuery("select r.room_number from room as r, hosting as h where h.roomfk_id=r.id and h.hosting_checkout='false'");
        return createQuery.getResultList();
    }

    public List<Room> freeRooms() {
        Query createQuery = null;

        createQuery = getEntityManager().createNativeQuery("SELECT r.room_number FROM room AS r WHERE r.room_status='LIVRE';");
        return createQuery.getResultList();

    }

    public List<Room> freeHostingRooms() {
        Query createQuery = null;

        createQuery = getEntityManager().createNativeQuery("select r.room_number from room as r, hosting as h where h.roomfk_id=r.id and h.hosting_checkout!='false'");
        return createQuery.getResultList();
    }

}
