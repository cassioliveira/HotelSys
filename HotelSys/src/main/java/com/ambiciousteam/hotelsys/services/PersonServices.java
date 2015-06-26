package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.PersonDao;
import com.ambiciousteam.hotelsys.model.Individual;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class PersonServices implements Serializable {

    @Inject
    private PersonDao personDao;

    public List<String> returnCities(int ufCode) {
        return personDao.returnCities(ufCode);
    }

    public List<Individual> completeMethod(String query) {
        return personDao.findByNameLike(query);
    }

}
