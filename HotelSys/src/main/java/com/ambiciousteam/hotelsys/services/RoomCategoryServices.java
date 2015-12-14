package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.RoomCategoryDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.RoomCategory;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class RoomCategoryServices {

    @Inject
    private RoomCategoryDao roomCategoryDao;

    @Transactional
    public void save(RoomCategory roomCategory) throws HotelSysException {
        this.roomCategoryDao.save(roomCategory);
    }

    @Transactional
    public void delete(RoomCategory roomCategory) throws HotelSysException {
        roomCategory = findById(roomCategory.getId());
        roomCategoryDao.delete(roomCategory);
    }

    public RoomCategory findById(Long id) {
        return roomCategoryDao.findById(id);
    }

    public List<RoomCategory> findAll() {
        return roomCategoryDao.findAll();
    }

}
