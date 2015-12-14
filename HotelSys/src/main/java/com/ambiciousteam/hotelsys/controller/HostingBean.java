package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.enumerations.PaymentWay;
import com.ambiciousteam.hotelsys.services.HostingServices;
import com.ambiciousteam.hotelsys.enumerations.ReasonTravel;
import com.ambiciousteam.hotelsys.enumerations.RoomStatus;
import com.ambiciousteam.hotelsys.enumerations.Transports;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.model.Payment;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.services.IndividualServices;
import com.ambiciousteam.hotelsys.services.RoomServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
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
    @Getter
    @Setter
    private IndividualServices individualServices;

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
    private List<Individual> individuals;

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
    
    @Getter
    private final List<PaymentWay> paymentWays;

    public HostingBean() {
        statusRooms = Arrays.asList(RoomStatus.values());
        transports = Arrays.asList(Transports.values());
        reasonsTravel = Arrays.asList(ReasonTravel.values());
        paymentWays = Arrays.asList(PaymentWay.values());
    }
    

    @PostConstruct
    public void init() {
        this.hostings = hostingServices.activeHostings();
        this.individuals = individualServices.findAll();
    }

    public void save() throws HotelSysException {
        if (getEditing()) {
            this.hostingServices.save(hosting);
            FacesUtil.sucessMessage("Cadastro de '" + hosting.getCode() + "' atualizado com sucesso!");
            FacesUtil.redirectTo("SearchHosting.xhtml");
        } else {
            this.hostingServices.save(hosting);
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

    public void hostingDown(){
        this.hostingServices.hostingDown(hosting);
        FacesUtil.sucessMessage("Baixa efetuada com sucesso!");
        FacesUtil.redirectTo("/HotelSys/Home.xhtml");
//        this.hosting = new Hosting();
    }

    public List<Hosting> getActiveHostings() {
        return hostingServices.activeHostings();
    }

    public List<Room> getRoomChange() {
        // TODO Falta fazer com que o quarto antigo seja setado para 'LIVRE' 
        // antes de transferir a hospedagem para o novo quarto
        if (getEditing()) {
            return hostingServices.roomChange(hosting);
        } else {
            return roomServices.getFreeRooms();
        }
    }
}
