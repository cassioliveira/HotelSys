package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Individual;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PersonDao extends AbstractDao<Individual> implements Serializable {

    public PersonDao() {
        super(Individual.class);
    }
    
    public List<String> returnCities(int ufCode) {
        Query createQuery;
        createQuery = getEntityManager().createNativeQuery("SELECT c.nome FROM cidades c where c.estado = " + ufCode);
        return createQuery.getResultList();
    }

     public List<String> returnCountries() {
        Query createQuery;
        createQuery = getEntityManager().createNativeQuery("SELECT nome FROM paises");
        return createQuery.getResultList();
    }
    
    
    public List<Individual> findByNameLike(String query) {

        Query createQuery = null;

//        if (StringUtils.isNotBlank(query)) {
        createQuery = getEntityManager().createQuery("from Individual c where c.name like :name");
        createQuery.setParameter("name", "%" + query + "%");
//        }
        return createQuery.getResultList();
    }
}
