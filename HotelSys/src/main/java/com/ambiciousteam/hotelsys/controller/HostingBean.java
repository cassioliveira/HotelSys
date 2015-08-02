package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.services.HostingServices;
import com.ambiciousteam.hotelsys.enumerations.ReasonTravel;
import com.ambiciousteam.hotelsys.enumerations.RoomStatus;
import com.ambiciousteam.hotelsys.enumerations.Transports;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.services.IndividualServices;
import com.ambiciousteam.hotelsys.services.RoomServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Model
public class HostingBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private HostingServices hostingServices;

    @Inject
    @Getter
    @Setter
    private Hosting hosting;

    @Inject
    @Getter
    @Setter
    private Hosting selectedHosting;

    @Inject
    IndividualServices individualServices;

    @Inject
    @Getter
    @Setter
    private RoomServices roomServices;

    @Inject
    @Getter
    @Setter
    private Individual individual;

    @Inject
    @Getter
    @Setter
    private Room room;

    @Getter
    private final List<Individual> individuals;

    @Getter
    private List<Room> availableRooms;

    @Getter
    private List<Hosting> hostings;

    @Getter
    private final List<RoomStatus> statusRooms;

    @Getter
    private final List<Transports> transports;

    @Getter
    private final List<ReasonTravel> reasonsTravel;

    private List<Individual> hostedNames;

    public HostingBean() {
        this.individuals = new ArrayList<>();
        statusRooms = Arrays.asList(RoomStatus.values());
        transports = Arrays.asList(Transports.values());
        reasonsTravel = Arrays.asList(ReasonTravel.values());
    }

    @PostConstruct
    public void init() {
        this.hostings = hostingServices.findAll();

    }

    public void save() throws HotelSysException {
        this.hostingServices.save(hosting);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro de '" + hosting.getCode() + "' atualizado com sucesso!");
            FacesUtil.redirectTo("SearchHosting.xhtml");
        } else {
            FacesUtil.sucessMessage("Hospedagem do quarto " + hosting.getRoomFK().getNumber() + " realizada com sucesso!");
            FacesUtil.redirectTo("/HotelSys/Home.xhtml");
        }
        hosting = new Hosting();
    }

    public void remove() throws HotelSysException {
        this.hostingServices.delete(selectedHosting);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return this.hosting.getId() != null;
    }

    public List<Individual> autoCompleteClients(String name) {
        return individualServices.completeMethod(name);
    }

//    public List<Individual> getHostedNames() {
//        hostedNames = hostingServices.getHostedNames();
//        return hostedNames;
//    }

    public void hostingDown() {
        this.hostingServices.getHostingDown(hosting);
    }
}