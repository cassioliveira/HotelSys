package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.HostingDao;
import com.ambiciousteam.hotelsys.dao.IndividualDao;
import com.ambiciousteam.hotelsys.dao.RoomDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.util.jpa.Transactional;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class HostingServices {

    @Inject
    private HostingDao hostingDao;

    //AQUI MUDAR PARA O SERVICE AO INVES DO DAO MAS TERÁ QUE ALTERAR O SERVICE DE QUARTO PARA NÃO SETAR LIVRE ANTES DE SALVAR A MENOS QUE SEJA UM NOVO QUARTO
    @Inject
    private RoomDao roomDao;

    @Inject
    private IndividualServices individualServices;

    @Transactional
    public void save(Hosting hosting) throws HotelSysException {
        Room room = hosting.getRoomFK();
        room.setStatus("OCUPADO");
        this.roomDao.save(room);
        this.hostingDao.save(hosting);
    }

    @Transactional
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

//    public List<Individual> getHostedNames() {
//        List<Individual> hostedNames = new ArrayList<>();
//        for (Individual individualName : individualServices.hostedNames()) {
//                hostedNames.add(individualName);
//        }
//        return hostedNames;
//    }

    public void getHostingDown(Hosting hosting) {
        Room room = hosting.getRoomFK();
        room.setStatus("LIVRE");
        this.roomDao.save(room);
        this.hostingDao.save(hosting);
    }
}
