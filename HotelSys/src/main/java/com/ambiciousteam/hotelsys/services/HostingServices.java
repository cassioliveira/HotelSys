package br.com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.HostingDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class HostingServices {

    @Inject
    private HostingDao hostingDao;

    @Transactional
    public void save(Hosting hosting) throws HotelSysException {
        this.hostingDao.save(hosting);
    }

    public void delete(Hosting hosting) throws HotelSysException {
        hosting = findById(hosting.getId());
        hostingDao.delete(hosting);
    }

    public Hosting findById(Long id) {
        return hostingDao.findById(id);
    }

    public List<Hosting> findAll() {
        return hostingDao.findAll();
    }

}
