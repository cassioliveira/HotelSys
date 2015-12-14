package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.HostingCategoryDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.HostingCategory;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class HostingCategoryServices {

    @Inject
    private HostingCategoryDao hostingCategoryDao;

    @Transactional
    public void save(HostingCategory hostingCategory) throws HotelSysException {
        this.hostingCategoryDao.save(hostingCategory);
    }

    @Transactional
    public void delete(HostingCategory hostingCategory) throws HotelSysException {
        hostingCategory = findById(hostingCategory.getId());
        hostingCategoryDao.delete(hostingCategory);
    }

    public HostingCategory findById(Long id) {
        return hostingCategoryDao.findById(id);
    }

    public List<HostingCategory> findAll() {
        return hostingCategoryDao.findAll();
    }

}
