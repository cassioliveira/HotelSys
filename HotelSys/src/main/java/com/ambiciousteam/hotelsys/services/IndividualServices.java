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
    private IndividualDao individualDao;

    @Transactional
    public void save(Individual client) throws HotelSysException {
        this.individualDao.save(client);
    }
    
    @Transactional
    public void delete(Individual client) throws HotelSysException {
        individualDao.delete(findById(client.getId()));
    }

    public Individual findById(Long id) {
        return individualDao.findById(id);
    }

    public List<Individual> findAll() {
        return individualDao.findAll();
    }

    public List<Individual> completeMethod(String query) {
        return individualDao.findByNameLike(query);
    }

    public List<Individual> hostedNames(){
        return individualDao.hostedNames();
    }
    
//    public String hasCPF(String cpf){
//        return individualDao.hasCPF(cpf);
//    }
}
