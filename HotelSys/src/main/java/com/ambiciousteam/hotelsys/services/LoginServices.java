package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.LoginDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Login;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class LoginServices implements Serializable {

    @Inject
    private LoginDao loginDao;

    @Transactional
    public void save(Login client) throws HotelSysException {
        this.loginDao.save(client);
    }
    
    @Transactional
    public void delete(Login client) throws HotelSysException {
        loginDao.delete(findById(client.getId()));
    }

    public Login findById(Long id) {
        return loginDao.findById(id);
    }

    public List<Login> findAll() {
        return loginDao.findAll();
    }
}
