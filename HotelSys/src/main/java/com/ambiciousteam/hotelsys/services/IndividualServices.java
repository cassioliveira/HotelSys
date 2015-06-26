package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.IndividualDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class IndividualServices implements Serializable {

    @Inject
    private IndividualDao clientDao;

    @Transactional
    public void save(Individual client) throws HotelSysException {
        this.clientDao.save(client);
    }
    
    @Transactional
    public void delete(Individual client) throws HotelSysException {
        clientDao.delete(findById(client.getId()));
    }

    public Individual findById(Long id) {
        return clientDao.findById(id);
    }

    public List<Individual> findAll() {
        return clientDao.findAll();
    }

    public List<Individual> completeMethod(String query) {
        return clientDao.findByNameLike(query);
    }

}
