package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.controller.DateTimeUtilBean;
import com.ambiciousteam.hotelsys.enumerations.ReasonTravel;
import com.ambiciousteam.hotelsys.enumerations.Transports;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Hosting entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
public class Hosting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hosting_missing_item", length = 255)
    private String missingItem;

    @Column(name = "hosting_increase", length = 10)
    private BigDecimal increase;

    @Enumerated(EnumType.STRING)
    @Column(name = "hosting_transport")
    private Transports transport;

    @Column(name = "hosting_food", length = 1)
    private boolean food;

    @Column(name = "hosting_discount", length = 10)
    private BigDecimal discount;

    @Column(name = "hosting_price", length = 10)
    private BigDecimal price;

    @Column(name = "hosting_source", length = 50)
    private String source;

    @Lob
    @Column(name = "hosting_observations")
    private String observations;

    @Enumerated(EnumType.STRING)
    @Column(name = "hosting_reason_travel", length = 40)
    private ReasonTravel reasonTravel;

    @Column(name = "hosting_dependent")
    private int quantityDependent;

    @Column(name = "hosting_quantity_child")
    private int quantityChild;

    @Column(name = "hosting_next_destination", length = 50)
    private String nextDestination;

    @Column(name = "hosting_date_input", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInput;

    @Column(name = "hosting_forecast_output")
    @Temporal(TemporalType.TIMESTAMP)
    private Date forecastOutput;

    @Column(name = "hosting_date_output")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOutput;

    @Column(name = "hosting_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(name = "hosting_payed") //FICA PARA A TELA DE EDIÇÃO DE HOSPEDAGEM!!!
    private boolean payed;

    @Column(name = "hosting_checkout") //FICA PARA A TELA DE EDIÇÃO DE HOSPEDAGEM!!!
    private boolean checkout;

    /* Attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "roomfk_id", nullable = false)
    private Room roomFK;

    @OneToMany(mappedBy = "hostingFK", targetEntity = Client.class)
    private List<Client> clients;

//    @ManyToOne
//    @JoinColumn(name = "employee_fk", referencedColumnName = "id") //TEM QUE FAZER QUE PEGUE O USUÁRIO LOGADO E NÃO O FUNCIONÁRIO!!
//    private Employee employeeFK;
//    @ManyToMany(mappedBy = "hostings", targetEntity = Service.class) //TEM QUE ESTAR NA TELA DE HOSPEDAGEM E NA TELA DE EDIÇÃO DE HOSPEDAGEM
//    private List<Service> services;
//
//    @OneToOne
//    private Person client; //INVESTIGAR: PORQUE TEM 'client' e 'clients'?
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMissingItem() {
        return missingItem;
    }

    public void setMissingItem(String missingItem) {
        this.missingItem = missingItem;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public void setIncrease(BigDecimal increase) {
        this.increase = increase;
    }

    public Transports getTransport() {
        return transport;
    }

    public void setTransport(Transports transport) {
        this.transport = transport;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public ReasonTravel getReasonTravel() {
        return reasonTravel;
    }

    public void setReasonTravel(ReasonTravel reasonTravel) {
        this.reasonTravel = reasonTravel;
    }

    public int getQuantityDependent() {
        return quantityDependent;
    }

    public void setQuantityDependent(int quantityDependent) {
        this.quantityDependent = quantityDependent;
    }

    public int getQuantityChild() {
        return quantityChild;
    }

    public void setQuantityChild(int quantityChild) {
        this.quantityChild = quantityChild;
    }

    public String getNextDestination() {
        return nextDestination;
    }

    public void setNextDestination(String nextDestination) {
        this.nextDestination = nextDestination;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public Date getForecastOutput() {
        return forecastOutput;
    }

    public void setForecastOutput(Date forecastOutput) {
        this.forecastOutput = forecastOutput;
    }

    public Date getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Date dateOutput) {
        this.dateOutput = dateOutput;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = new DateTimeUtilBean().dateHour();
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public Room getRoomFK() {
        return roomFK;
    }

    public void setRoomFK(Room roomFK) {
        this.roomFK = roomFK;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hosting other = (Hosting) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
