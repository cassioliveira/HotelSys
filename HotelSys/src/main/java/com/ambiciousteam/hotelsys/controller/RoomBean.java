package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.services.RoomServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Model
public class RoomBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private RoomServices roomServices;

    @Inject
    @Getter
    @Setter
    private Room room;

    @Inject
    @Getter
    @Setter
    private Room selectedRoom;

    @Getter
    private List<Room> rooms;

    @PostConstruct
    public void init() {
        this.rooms = roomServices.findAll();
    }

    public void save() throws HotelSysException {
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
        return roomServices.getBusyRooms();
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return this.room.getId() != null;
    }
}
