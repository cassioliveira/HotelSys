package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.RoomDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author cassio
 */
public class RoomServices implements Serializable {

    @Inject
    private RoomDao roomDao;
    
    @Getter
    private List<Room> rooms;

    @PostConstruct
    public void init() {
        this.rooms = roomDao.findAll();
    }
    
    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>();
        for (Room freeRoom : roomDao.findAll()) {
            if (freeRoom.getStatus().equals("LIVRE")) {
                freeRooms.add(freeRoom);
            }
        }
        return freeRooms;
    }
    
    public List<Room> getBusyRooms() {
        List<Room> busyRooms = new ArrayList<>();
        for (Room busyRoom : roomDao.findAll()) {
            if (busyRoom.getStatus().equals("OCUPADO")) {
                busyRooms.add(busyRoom);
            }
        }
        return busyRooms;
    }

    @Transactional
    public void save(Room room) throws HotelSysException {
        if (room.getId() == null && isRoomDuplicated(room.getNumber())) {
            throw new HotelSysException("Um quarto com esse número já existe. Por favor informe outro número");
        } else {
            // SE FOR PERMITIDO EDIÇÃO DO QUARTO ALOCADO PARA UMA HOSPEDAGEM, DEVE SER FEITA UMA CONSULTA QUE 
            // QUANDO O ID DO QUARTO FOR IGUAL AO ID DO ROOOMFK DA HOSPEDAGEM, SETAR O STATUS PARA 'OCUPADO', SENAO, PARA 'LIVRE'.
            room.setStatus("LIVRE");
            this.roomDao.save(room);
        }
    }

    @Transactional
    public void delete(Room room) throws HotelSysException {
        roomDao.delete(findById(room.getId()));
    }

    public Room findById(Long id) {
        return roomDao.findById(id);
    }

    public List<Room> findAll() {
        return roomDao.findAll();
    }

//    public List<Room> busyRooms() {
//        return roomDao.busyRooms();
//    }

    /**
     * Metodo que verifica se o quarto que está sendo informado já existe no
     * sistema baseada no número do mesmo, que não pode ser repetido.
     *
     * @param room
     * @return
     */
    public boolean isRoomDuplicated(String room) {
        for (String selectedRoom : roomDao.roomsNumbers()) {
            if (selectedRoom.equals(room)) {
                return true;
            }
        }
        return false;
    }
}
