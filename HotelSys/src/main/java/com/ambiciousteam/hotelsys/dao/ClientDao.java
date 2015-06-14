package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Client;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ClientDao extends AbstractDao<Client> implements Serializable {

    public ClientDao() {
        super(Client.class);
    }

    public List<Client> findByNameLike(String query) {

        Query createQuery = null;

        if (StringUtils.isNotBlank(query)) {
            createQuery = getEntityManager().createQuery("from Client c where c.name like :name");
            createQuery.setParameter("name", "%" + query + "%");
        }
        return createQuery.getResultList();
    }
}
