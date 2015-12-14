package com.ambiciousteam.hotelsys.services;

import com.ambiciousteam.hotelsys.dao.HostingDao;
import com.ambiciousteam.hotelsys.dao.RoomDao;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
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

    @Inject
    private RoomServices roomServices;

    //AQUI MUDAR PARA O SERVICE AO INVES DO DAO MAS TERÁ QUE ALTERAR O SERVICE DE QUARTO PARA NÃO SETAR LIVRE ANTES DE SALVAR A MENOS QUE SEJA UM NOVO QUARTO
    @Inject
    private RoomDao roomDao;

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

    /**
     * Método que pega todas as hospedagens do banco e retorna apenas as que
     * estão ativas.
     *
     * @return
     */
    public List<Hosting> activeHostings() {
        List<Hosting> activeHostings = new ArrayList<>();
        for (Hosting activeHosting : hostingDao.findAll()) {
            if (activeHosting.isCheckout() == false) {
                activeHostings.add(activeHosting);
            }
        }
        return activeHostings;
    }

    @Transactional
    public void hostingDown(Hosting hosting) {
        Room room = hosting.getRoomFK();
        room.setStatus("LIVRE");
        hosting.setCheckout(true);
        this.roomDao.save(room);
        this.hostingDao.save(hosting);
    }

    /**
     * Retorna uma lista com todos os quartos disponíveis junto com o quarto
     * selecionado durante uma edição de hospedagem. Este método permite que, ao
     * editar uma hospedagem, o usuário possa transferir uma hospedagem de um
     * quarto para outro que esteja disponível, caso seja necessário.
     *
     * @param hosting
     * @return
     */
    public List<Room> roomChange(Hosting hosting) {
        List<Room> roomsEdit = new ArrayList<>();
        Room room = hosting.getRoomFK();
        roomsEdit.add(room);
        for (Room filteredRoom : roomServices.getFreeRooms()) {
            roomsEdit.add(filteredRoom);
        }
        return roomsEdit;
    }
}
