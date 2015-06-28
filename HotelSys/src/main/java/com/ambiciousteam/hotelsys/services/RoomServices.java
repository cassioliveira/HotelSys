package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.RoomDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class RoomServices implements Serializable {

    @Inject
    private RoomDao roomDao;

    public List<Room> getFreeRooms() {
        return roomDao.freeRooms();
    }

    @Transactional
    public void save(Room room) throws HotelSysException {
        this.roomDao.save(room);
    }

    public void delete(Room room) throws HotelSysException {
        roomDao.delete(findById(room.getId()));
    }

    public Room findById(Long id) {
        return roomDao.findById(id);
    }

    public List<Room> findAll() {
        return roomDao.findAll();
    }

    public List<Room> busyRooms() {
        return roomDao.busyRooms();
    }

    public Long findByNumber(String number) {
        List<Room> rooms = roomDao.findAll();
        Long roomId = null;
        for (Room room : rooms) {
            if (room.getNumber().equals(number)) {
                roomId = room.getId();
            }
        }
        return roomId;
    }
}
