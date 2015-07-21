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
    
    /**
     * Método que retorna o número de todos os quartos cadastrados no sistema.
     * @return 
     */
     public List<String> roomsNumbers() {
        Query createQuery;

        createQuery = getEntityManager().createQuery("SELECT r.number FROM Room as r");
        return createQuery.getResultList();
    }

    public List<Room> busyRooms() {
        Query createQuery;

        createQuery = getEntityManager().createNativeQuery("select r.room_number from room as r, hosting as h where h.roomfk_id=r.id and h.hosting_checkout='false'");
        return createQuery.getResultList();
    }

    public List<Room> freeRooms() {
        Query createQuery;

        createQuery = getEntityManager().createNativeQuery("SELECT r.room_number FROM room AS r WHERE r.room_status='LIVRE';");
        System.err.println("LISTA DE QUARTOS DO DAO: " + createQuery.getResultList());
        return createQuery.getResultList();

    }

    public List<Room> freeHostingRooms() {
        Query createQuery;

        createQuery = getEntityManager().createNativeQuery("select r.room_number from room as r, hosting as h where h.roomfk_id=r.id and h.hosting_checkout!='false'");
        return createQuery.getResultList();
    }

}
