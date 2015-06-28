package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.services.RoomServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
@Model
public class roomBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RoomServices roomServices;

    @Inject
    private Room room;

    @Inject
    private Room selectedRoom;

    public void save() throws HotelSysException {
        this.room.setStatus("LIVRE");
        this.roomServices.save(room);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro do quarto nº " + room.getNumber() + " atualizado com sucesso!");
            FacesUtil.redirectTo("SearchRoom.xhtml");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
            FacesUtil.redirectTo("CadastreRoom.xhtml");
        }
        room = new Room();
    }

    public void remove() throws HotelSysException {
        this.roomServices.delete(selectedRoom);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    public List<Room> getFreeRooms() {
        return roomServices.getFreeRooms();
    }

    public List<Room> getBusyRooms() {
        return roomServices.busyRooms();
    }

    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Room> getRooms() {
        return roomServices.findAll();
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.room.getId() != null;
    }

    public RoomServices getRoomServices() {
        return roomServices;
    }

    public void setRoomServices(RoomServices roomServices) {
        this.roomServices = roomServices;
    }

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
}
