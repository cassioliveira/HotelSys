package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.ClientDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Client;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class ClientServices implements Serializable {

    @Inject
    private ClientDao clientDao;

    @Transactional
    public void save(Client client) throws HotelSysException {
        this.clientDao.save(client);
    }

    public void delete(Client client) throws HotelSysException {
        client = findById(client.getId());
        clientDao.delete(client);
    }

    public Client findById(Long id) {
        return clientDao.findById(id);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public List<Client> completeMethod(String query) {
        return clientDao.findByNameLike(query);
    }

}
