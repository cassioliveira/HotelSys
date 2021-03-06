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

    /**
     * Retorna os números dos quartos que estão com status 'OCUPADO'
     * @return 
     */
    public List<Room> busyRooms() {
        Query createQuery;

        createQuery = getEntityManager().createQuery("SELECT r.number FROM Room AS r WHERE r.status='OCUPADO'");
        return createQuery.getResultList();
    }

}
