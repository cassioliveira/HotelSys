package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.services.RoomCategoryServices;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.RoomCategory;
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
public class RoomCategoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private RoomCategoryServices roomCategoryServices;

    @Inject
    @Getter
    @Setter
    private RoomCategory roomCategory;

    @Inject
    @Getter
    @Setter
    private RoomCategory selectedRoomCategory;

    @Getter
    private List<RoomCategory> roomCategories;

    public RoomCategoryBean() {
    }

    @PostConstruct
    public void init() {
        this.roomCategories = roomCategoryServices.findAll();
    }

    public void save() throws HotelSysException {
        if (getEditing()) {
            this.roomCategoryServices.save(roomCategory);
            FacesUtil.sucessMessage("Cadastro da categoria'" + roomCategory.getName() + "' atualizado com sucesso!");
        } else {
            this.roomCategoryServices.save(roomCategory);
            FacesUtil.sucessMessage("Categoria " + roomCategory.getName() + " cadastrada com sucesso!");
        }
            FacesUtil.redirectTo("SearchRoomCategory.xhtml");
            roomCategory = new RoomCategory();
    }

    public void remove() throws HotelSysException {
        this.roomCategoryServices.delete(selectedRoomCategory);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return this.roomCategory.getId() != null;
    }
}
