package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.ReasonTravel;
import com.ambiciousteam.hotelsys.enumerations.Transports;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Class to modelling the Hosting entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
@Data
public class Hosting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hosting_code")
    private String code;

    @Column(name = "hosting_missing_item", length = 255)
    private String missingItem;

    @Enumerated(EnumType.STRING)
    @Column(name = "hosting_transport")
    private Transports transport;

    @Column(name = "hosting_food", length = 1)
    private boolean food;

    @Column(name = "hosting_source", length = 50)
    private String source;

    @Lob
    @Column(name = "hosting_observations")
    private String observations;

    @Enumerated(EnumType.STRING)
    @Column(name = "hosting_reason_travel", length = 40)
    private ReasonTravel reasonTravel;

    @Column(name = "hosting_dependent")
    private Integer quantityDependent;

    @Column(name = "hosting_quantity_child")
    private Integer quantityChild;

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

    /**
     * Atributo referente ao armazenamento da data em que o registro foi
     * criado/alterado.
     */
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

    @OneToOne
    @JoinColumn(name = "individualfk_id", nullable = false)
    private Individual individualFK;

    @OneToOne
    @JoinColumn(name = "paymentfk_id")
    private Payment paymentFK;

//    @ManyToOne
//    @JoinColumn(name = "employee_fk", referencedColumnName = "id") //TEM QUE FAZER QUE PEGUE O USUÁRIO LOGADO E NÃO O FUNCIONÁRIO!!
//    private Employee employeeFK;
//    @ManyToMany(mappedBy = "hostings", targetEntity = Service.class) //TEM QUE ESTAR NA TELA DE HOSPEDAGEM E NA TELA DE EDIÇÃO DE HOSPEDAGEM
//    private List<Service> services;
}
